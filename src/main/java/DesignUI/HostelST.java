package DesignUI;

import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import Models.*;
import Utils.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HostelST extends javax.swing.JFrame {

    private static Student currentUser;
    private static Application currentUserApplication;
    private static Room currentUserRoom;
    private static ArrayList<Room> availableRooms;
    private static ArrayList<String> roomTypes;
    private static Room selectedRoom = null;
    private static String selectedRoomType = null;

    /**
     * Creates new form HostelST
     */
    private static CardLayout card;

    // custom component properties
    private static final Color btnBgColor = Color.BLACK;
    private static final Color btnHoverColor = new Color(43, 43, 43);

    Border margin = new EmptyBorder(10, 10, 10, 10);
    CompoundBorder btnMarginBorder = new CompoundBorder(null, margin);
    
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
        currentUserApplication = ApplicationHandling.getCurrentStudentApplication(currentUser);
        currentUserRoom = currentUserApplication.getRoom();
        availableRooms = RoomHandling.getAvailableRooms();
        roomTypes = RoomTypeHandling.getRoomTypes();
        PaymentHandling.refreshPaymentFile();
    }

    // setters and getters
    public static void setSelectedRoom(Room selectedRoom) {
        HostelST.selectedRoom = selectedRoom;
    }

    public static void setSelectedRoomType(String selectedRoomType) {
        HostelST.selectedRoomType = selectedRoomType;
    }

    public static Room getSelectedRoom() {
        return selectedRoom;
    }

    public static String getSelectedRoomType() {
        return selectedRoomType;
    }

    public static Student getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Student currentUser) {
        HostelST.currentUser = currentUser;
    }

    public static Application getCurrentUserApplication() {
        return currentUserApplication;
    }

    public static void setCurrentUserApplication(Application currentUserApplication) {
        HostelST.currentUserApplication = currentUserApplication;
    }

    public static ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    public static void setAvailableRooms(ArrayList<Room> availableRooms) {
        HostelST.availableRooms = availableRooms;
    }

    public static ArrayList<String> getRoomTypes() {
        return roomTypes;
    }

    public static void setRoomTypes(ArrayList<String> roomTypes) {
        HostelST.roomTypes = roomTypes;
    }

    public static Room getCurrentUserRoom() {
        return currentUserRoom;
    }

    public static void setCurrentUserRoom(Room currentUserRoom) {
        HostelST.currentUserRoom = currentUserRoom;
    }

    // methods to show pages
    public static void showHome() {
        HomeST homePanel = new HomeST();
        mainPanel.add(homePanel, "home");
        card.show(mainPanel, "home");
    }

    public static void showRooms() {
        RoomsST roomsPanel = new RoomsST();
        mainPanel.add(roomsPanel, "rooms");
        card.show(mainPanel, "rooms");
    }

    public static void showApplication() {
        if (selectedRoomType == null && currentUserRoom == null) {
            PopUpWindow.showErrorMessage("Please select a room type in the Rooms page first.", "Error");
            HostelST.showRooms();
            return;
        }
        ApplicationST applicationPanel = new ApplicationST();
        mainPanel.add(applicationPanel, "apply");
        card.show(mainPanel, "apply");
    }

    public static void showTnC() {
        ApplyTnCST TnCPanel = new ApplyTnCST();
        mainPanel.add(TnCPanel, "T&C");
        card.show(mainPanel, "T&C");
    }

    public static void showProfile() {
        ProfileST profilePanel = new ProfileST();
        mainPanel.add(profilePanel, "profile");
        card.show(mainPanel, "profile");
    }

    public static void showPayment() {
        PaymentST paymentPanel = new PaymentST();
        mainPanel.add(paymentPanel, "payment");
        card.show(mainPanel, "payment");
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    public static CardLayout getCardManager() {
        return card;
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
        homeBtn = new javax.swing.JToggleButton();
        roomsBtn = new javax.swing.JToggleButton();
        applicationBtn = new javax.swing.JToggleButton();
        profileBtn = new javax.swing.JToggleButton();
        paymentBtn = new javax.swing.JToggleButton();
        signOutBtn = new javax.swing.JToggleButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

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
        homeBtn.setText("   Home           ");
        homeBtn.setBorder(btnMarginBorder);
        homeBtn.setBorderPainted(false);
        homeBtn.setFocusPainted(false);
        homeBtn.setFocusable(false);
        homeBtn.setRequestFocusEnabled(false);
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtnExitHover(evt);
            }
        });
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        sidePanel.add(homeBtn);

        roomsBtn.setBackground(new java.awt.Color(0, 0, 0));
        roomsBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        roomsBtn.setForeground(new java.awt.Color(255, 255, 255));
        roomsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bed-alt.png"))); // NOI18N
        roomsBtn.setText("   Rooms         ");
        roomsBtn.setBorder(btnMarginBorder);
        roomsBtn.setBorderPainted(false);
        roomsBtn.setFocusable(false);
        roomsBtn.setRequestFocusEnabled(false);
        roomsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roomsBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                roomsBtnExitHover(evt);
            }
        });
        roomsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsBtnActionPerformed(evt);
            }
        });
        sidePanel.add(roomsBtn);

        applicationBtn.setBackground(new java.awt.Color(0, 0, 0));
        applicationBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        applicationBtn.setForeground(new java.awt.Color(255, 255, 255));
        applicationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form.png"))); // NOI18N
        applicationBtn.setText("    Apply          ");
        applicationBtn.setBorder(btnMarginBorder);
        applicationBtn.setBorderPainted(false);
        applicationBtn.setFocusable(false);
        applicationBtn.setRequestFocusEnabled(false);
        applicationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applicationBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applicationBtnExitHover(evt);
            }
        });
        applicationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationBtnActionPerformed(evt);
            }
        });
        sidePanel.add(applicationBtn);

        profileBtn.setBackground(new java.awt.Color(0, 0, 0));
        profileBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        profileBtn.setText("   Profile        ");
        profileBtn.setBorder(btnMarginBorder);
        profileBtn.setBorderPainted(false);
        profileBtn.setFocusable(false);
        profileBtn.setRequestFocusEnabled(false);
        profileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileBtnExitHover(evt);
            }
        });
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        sidePanel.add(profileBtn);

        paymentBtn.setBackground(new java.awt.Color(0, 0, 0));
        paymentBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        paymentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dollar.png"))); // NOI18N
        paymentBtn.setText("   Payment     ");
        paymentBtn.setBorder(btnMarginBorder);
        paymentBtn.setBorderPainted(false);
        paymentBtn.setFocusable(false);
        paymentBtn.setRequestFocusEnabled(false);
        paymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentBtnExitHover(evt);
            }
        });
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });
        sidePanel.add(paymentBtn);

        signOutBtn.setBackground(new java.awt.Color(0, 0, 0));
        signOutBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        signOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/exit.png"))); // NOI18N
        signOutBtn.setText("   Sign Out     ");
        signOutBtn.setBorder(btnMarginBorder);
        signOutBtn.setBorderPainted(false);
        signOutBtn.setFocusable(false);
        signOutBtn.setRequestFocusEnabled(false);
        signOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signOutBtnHover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutBtnExitHover(evt);
            }
        });
        signOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutBtnActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO set color back to bg color when clicked:
        showHome();
        homeBtn.setFocusPainted(false);
        homeBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void homeBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnHover
        // TODO add your handling code here:
        homeBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_homeBtnHover

    private void homeBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnExitHover
        // TODO add your handling code here:
        homeBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_homeBtnExitHover

    private void roomsBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsBtnHover
        // TODO add your handling code here:
        roomsBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_roomsBtnHover

    private void roomsBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsBtnExitHover
        // TODO add your handling code here:
        roomsBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_roomsBtnExitHover

    private void roomsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsBtnActionPerformed
        // TODO add your handling code here:
        roomsBtn.setBackground(btnBgColor);
        showRooms();
    }//GEN-LAST:event_roomsBtnActionPerformed

    private void paymentBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnHover
        // TODO add your handling code here:
        paymentBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_paymentBtnHover

    private void paymentBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnExitHover
        // TODO add your handling code here:
        paymentBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_paymentBtnExitHover

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        // TODO add your handling code here:
        paymentBtn.setBackground(btnBgColor);
        showPayment();
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void profileBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnHover
        // TODO add your handling code here:
        profileBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_profileBtnHover

    private void profileBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnExitHover
        // TODO add your handling code here:
        profileBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_profileBtnExitHover

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        profileBtn.setBackground(btnBgColor);
        showProfile();
    }//GEN-LAST:event_profileBtnActionPerformed

    private void signOutBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutBtnHover
        // TODO add your handling code here:
        signOutBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_signOutBtnHover

    private void signOutBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutBtnExitHover
        // TODO add your handling code here:
        signOutBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_signOutBtnExitHover

    private void signOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutBtnActionPerformed
        // TODO add your handling code here:
        signOutBtn.setBackground(btnBgColor);
        PopUpWindow.showGoodByeMessage("Thank you for using the system. See you!", "Sign Out");
        currentUser = null;
        setVisible(false);
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_signOutBtnActionPerformed

    private void applicationBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationBtnHover
        // TODO add your handling code here:
        applicationBtn.setBackground(btnHoverColor);
    }//GEN-LAST:event_applicationBtnHover

    private void applicationBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationBtnExitHover
        // TODO add your handling code here:
        applicationBtn.setBackground(btnBgColor);
    }//GEN-LAST:event_applicationBtnExitHover

    private void applicationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationBtnActionPerformed
        // TODO add your handling code here:
        showApplication();
    }//GEN-LAST:event_applicationBtnActionPerformed


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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HostelST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton applicationBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JToggleButton homeBtn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private static javax.swing.JPanel mainPanel;
    private javax.swing.JToggleButton paymentBtn;
    private javax.swing.JToggleButton profileBtn;
    private javax.swing.JToggleButton roomsBtn;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JToggleButton signOutBtn;
    // End of variables declaration//GEN-END:variables
}
