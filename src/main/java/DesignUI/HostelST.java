package DesignUI;

import java.awt.Color;
import Models.*;
import Models.Payment.PaymentStatus;
import Utils.*;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HostelST extends javax.swing.JFrame {

    private static Student currentUser;
    private static Application currentUserApplication;
    private static Room currentUserRoom;
    private static ApplicationPaymentDetails paymentDetails;
    private static Room selectedRoom = null;

    private static CardLayout card;

    private static final Color BUTTON_BG_COLOR = Color.BLACK;
    private static final Color BUTTON_HOVER_COLOR = new Color(43, 43, 43);

    // Constructor
    public HostelST() {
        initData();
        initComponents();
        card = (CardLayout) mainPanel.getLayout();
        showHome();
        if (currentUserRoom == null) {
            System.out.println("You have no room");
        }
        Splash screen = new Splash();
        screen.setVisible(true);
        screen.dispose();
        setVisible(true);
    }

    public static void initData() {
        currentUser = Login.getCurrentUser();
        currentUserApplication = ApplicationHandling.getStudentApplication(currentUser);
        currentUserRoom = currentUserApplication.getRoom();
        paymentDetails = new ApplicationPaymentDetails(currentUserApplication);
        if (paymentDetails.getStatus().equals(PaymentStatus.PAID)
                || paymentDetails.getStatus().equals(PaymentStatus.PENDING)) {
            currentUserRoom.setStatus("Occupied");
            RoomHandling.updateRoomInFile(currentUserRoom);
        }
    }

    // setters and getters
    public static void setSelectedRoom(Room selectedRoom) {
        HostelST.selectedRoom = selectedRoom;
    }

    public static Room getSelectedRoom() {
        return selectedRoom;
    }

    public static Student getCurrentUser() {
        return currentUser;
    }

    public static Application getCurrentUserApplication() {
        return currentUserApplication;
    }

    public static Room getCurrentUserRoom() {
        return currentUserRoom;
    }

    public static ApplicationPaymentDetails getCurrentPaymentDetails() {
        return paymentDetails;
    }

    // methods to show pages 
    public static void showHome() {
        mainPanel.add(new HomeST(), "home");
        card.show(mainPanel, "home");
    }

    public static void showRooms() {
        mainPanel.add(new RoomsST(), "rooms");
        card.show(mainPanel, "rooms");
    }

    public static void showApplication() {
        if (selectedRoom == null && currentUserRoom == null) {
            PopUpWindow.showErrorMessage("Please select a room type in the Rooms page first.", "Error");
            HostelST.showRooms();
            return;
        }
        mainPanel.add(new ApplicationST(), "apply");
        card.show(mainPanel, "apply");
    }

    public static void showTnC() {
        mainPanel.add(new ApplyTnCST(), "T&C");
        card.show(mainPanel, "T&C");
    }

    public static void showProfile() {
        mainPanel.add(new ProfileST(), "profile");
        card.show(mainPanel, "profile");
    }

    public static void showPayment() {
        switch (currentUserApplication.getStatus()) {
            case Config.NOT_APPLICABLE ->
                PopUpWindow.showErrorMessage("Please apply for a room first.", "Error");
            case "Pending" ->
                PopUpWindow.showErrorMessage("Please wait until your application has been accepted.", "Error");
            default -> {
                mainPanel.add(new PaymentST(), "payment");
                card.show(mainPanel, "payment");
            }
        }
    }

    public void signOut() {
        PopUpWindow.showGoodByeMessage("Thank you for using the system. See you!", "Sign Out");
        setVisible(false);
        dispose();
        new Login().setVisible(true);
    }

    public static void apply(HashMap<String, String> applicationForm) {
        DateTimeFormatter inputFormatter = Config.dateFormats.ST_APPLICATION_DATE_INPUT.getFormatter();
        DateTimeFormatter createDateFormatter = Config.dateFormats.FILE_APPLICATION_CREATE_DATE.getFormatter();
        DateTimeFormatter dateFormatter = Config.dateFormats.FILE_APPLICATION_START_END_DATE.getFormatter();

        currentUser.setNationality(applicationForm.get("nationality"));
        currentUser.setRace(applicationForm.get("race"));
        currentUser.setReligion(applicationForm.get("religion"));
        currentUser.setPermanentAddress(applicationForm.get("address"));
        currentUser.setMedicalCondition(applicationForm.get("medicalCondition"));
        currentUser.setEmerContactName(applicationForm.get("emerContactName"));
        currentUser.setEmerContactRelationship(applicationForm.get("emerContactRelationship"));
        currentUser.setEmerContactNo(applicationForm.get("emerContactNo"));
        UserHandling.updateStudentDetail(currentUser);

        String newApplicationID = String.format("A%03d", ApplicationHandling.getTotalApplications().size() + 1);
        String createDate = LocalDateTime.now().format(createDateFormatter);

        String checkInDateString = applicationForm.get("checkInDate");
        LocalDateTime startDate = LocalDate.parse(checkInDateString, inputFormatter).atTime(12, 0);
        String startDateString = startDate.format(dateFormatter);

        String stayPeriodString = applicationForm.get("periodOfStay");
        int stayLength = Integer.parseInt(stayPeriodString) + 1;

        LocalDateTime endDate = startDate.plusYears(stayLength);
        String endDateString = endDate.format(dateFormatter);

        Application application = new Application(
                newApplicationID,
                currentUser,
                selectedRoom,
                "Pending", createDate,
                startDateString,
                endDateString);
        ApplicationHandling.addNewApplication(application);
        currentUserApplication = application;
        currentUserRoom = selectedRoom;

        PopUpWindow.showSuccessfulMessage("Application has been sent to JomStay. We will get back to you when your application has been checked and accepted.", "Success");
        showApplication();
    }

    public static void proceedWithPayment(String rentalPeriod, double selectedAmt) {
        LocalDate dateStarted = LocalDate.parse(currentUserApplication.getStartDate(), Config.dateFormats.FILE_APPLICATION_START_END_DATE.getFormatter());
        LocalDate dateEnded = LocalDate.parse(currentUserApplication.getEndDate(), Config.dateFormats.FILE_APPLICATION_START_END_DATE.getFormatter());
        String dateStartedString = dateStarted.format(Config.dateFormats.DISPLAY_APPLICATION_START_END_DATE.getFormatter());
        String dateEndedString = dateEnded.format(Config.dateFormats.DISPLAY_APPLICATION_START_END_DATE.getFormatter());

        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("Customer Name", currentUser.getName().replace("_", " "));
        data.put("Check-In Date", dateStartedString);
        data.put("Check-Out Date", dateEndedString);
        data.put("Rental Period", rentalPeriod);
        data.put("Room Type", currentUserRoom.getRoomType().getTypeName());
        data.put("Room Number", currentUserRoom.getRoomID());
        data.put("Total Price", "RM" + selectedAmt);

        Runnable onClose = () -> {
            Login.getHostelFrame().dispose();
            HostelST hostelST = new HostelST();
            Login.setHostelFrame(hostelST);
        };

        ReceiptGUI gui = new ReceiptGUI(data, onClose);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        roomsBtn = new javax.swing.JButton();
        applicationBtn = new javax.swing.JButton();
        profileBtn = new javax.swing.JButton();
        paymentBtn = new javax.swing.JButton();
        signOutBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1070, 80));

        sidePanel.setBackground(new java.awt.Color(0, 0, 0));
        sidePanel.setLayout(new java.awt.GridLayout(7, 1, 0, 30));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/jomstaybg_small.png"))); // NOI18N
        sidePanel.add(logo);

        homeBtn.setBackground(new java.awt.Color(0, 0, 0));
        homeBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/house-chimney.png"))); // NOI18N
        homeBtn.setText("Home");
        homeBtn.setBorder(null);
        homeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeBtn.setFocusPainted(false);
        homeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        homeBtn.setIconTextGap(30);
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(homeBtn);

        roomsBtn.setBackground(new java.awt.Color(0, 0, 0));
        roomsBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        roomsBtn.setForeground(new java.awt.Color(255, 255, 255));
        roomsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bed-alt.png"))); // NOI18N
        roomsBtn.setText("Rooms");
        roomsBtn.setBorder(null);
        roomsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomsBtn.setFocusPainted(false);
        roomsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        roomsBtn.setIconTextGap(30);
        roomsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        roomsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(roomsBtn);

        applicationBtn.setBackground(new java.awt.Color(0, 0, 0));
        applicationBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        applicationBtn.setForeground(new java.awt.Color(255, 255, 255));
        applicationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form.png"))); // NOI18N
        applicationBtn.setText("Apply");
        applicationBtn.setBorder(null);
        applicationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        applicationBtn.setFocusPainted(false);
        applicationBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        applicationBtn.setIconTextGap(30);
        applicationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        applicationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(applicationBtn);

        profileBtn.setBackground(new java.awt.Color(0, 0, 0));
        profileBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        profileBtn.setText("Profile");
        profileBtn.setBorder(null);
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.setFocusPainted(false);
        profileBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        profileBtn.setIconTextGap(30);
        profileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(profileBtn);

        paymentBtn.setBackground(new java.awt.Color(0, 0, 0));
        paymentBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        paymentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dollar.png"))); // NOI18N
        paymentBtn.setText("Payment");
        paymentBtn.setBorder(null);
        paymentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentBtn.setFocusPainted(false);
        paymentBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        paymentBtn.setIconTextGap(30);
        paymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(paymentBtn);

        signOutBtn.setBackground(new java.awt.Color(0, 0, 0));
        signOutBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        signOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/exit.png"))); // NOI18N
        signOutBtn.setText("Sign Out");
        signOutBtn.setBorder(null);
        signOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutBtn.setFocusPainted(false);
        signOutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        signOutBtn.setIconTextGap(30);
        signOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitHover(evt);
            }
        });
        signOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostelST.this.actionPerformed(evt);
            }
        });
        sidePanel.add(signOutBtn);

        jPanel2.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 690));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());
        jPanel2.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 1070, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        switch (evt.getActionCommand()) {
            case "Home" ->
                showHome();
            case "Rooms" ->
                showRooms();
            case "Apply" ->
                showApplication();
            case "Profile" ->
                showProfile();
            case "Payment" ->
                showPayment();
            case "Sign Out" ->
                signOut();
            default -> {
                break;
            }
        }
    }//GEN-LAST:event_actionPerformed

    private void btnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHover
        evt.getComponent().setBackground(BUTTON_HOVER_COLOR);
    }//GEN-LAST:event_btnHover

    private void btnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitHover
        evt.getComponent().setBackground(BUTTON_BG_COLOR);
    }//GEN-LAST:event_btnExitHover

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HostelST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HostelST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HostelST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HostelST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applicationBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton homeBtn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private static javax.swing.JPanel mainPanel;
    private javax.swing.JButton paymentBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton roomsBtn;
    private static javax.swing.JPanel sidePanel;
    private javax.swing.JButton signOutBtn;
    // End of variables declaration//GEN-END:variables
}
