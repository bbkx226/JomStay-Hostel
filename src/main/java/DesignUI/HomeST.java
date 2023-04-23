/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import Models.Application;
import Models.Room;
import Models.RoomType;
import Utils.ApplicationPaymentDetails;
import Utils.Config;
import java.awt.Color;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class HomeST extends javax.swing.JPanel {
    
    private static Room room;
    private static Application application;
    private static RoomType roomType;
    private static DateTimeFormatter formatter;
    private static ApplicationPaymentDetails paymentDetails;
    
    /**
     * Creates new form HomeST
     */
    public HomeST() {
        initComponents();
        if (HostelST.getCurrentUserRoom() != null) {
            initData();
            setLabels();
        }
        
    }
    
    // initialize data to show in GUI    
    private static void initData() {
        room = HostelST.getCurrentUserRoom();
        application = HostelST.getCurrentUserApplication();
        roomType = room.getRoomType();
        formatter = Config.dateFormats.DISPLAY_APPLICATION_START_END_DATE.getFormatter();
        paymentDetails = HostelST.getCurrentPaymentDetails();
    }

    // set the labels that appear on the dashboard
    private static void setLabels() {
        roomNumLabel.setText(room.getRoomID());
        servicingLabel.setText(room.getServicingString());
        checkInDateLabel.setText(application.getLocalStartDate().format(formatter));
        checkOutDateLabel.setText(application.getLocalEndDate().format(formatter));
        applicationStatusLabel.setText(application.getStatus());
        switch (application.getStatus()) {
            case "Pending" -> applicationStatusLabel.setForeground(Color.BLUE);
            case "Rejected" -> {
                applicationStatusLabel.setForeground(Color.RED);
                reApplyBtn.setVisible(true);
            }
            case "Accepted" -> applicationStatusLabel.setForeground(Color.GREEN);
            default -> {
                applicationStatusLabel.setForeground(Color.BLACK);
                reApplyBtn.setVisible(true);
            }
        }
        roomTypeLabel.setText(roomType.getTypeName());
        if (application.getStatus().equals("Accepted")) {
            paymentStatusLabel.setText(paymentDetails.getStatusString());
            switch (paymentDetails.getStatus()) {
                case PENDING -> paymentStatusLabel.setForeground(Color.BLUE);
                case OVERDUE -> paymentStatusLabel.setForeground(Color.RED);
                case PAID -> paymentStatusLabel.setForeground(Color.GREEN);
                default -> paymentStatusLabel.setForeground(Color.BLACK);
            }
            dueDateLabel.setText(paymentDetails.getDueDateString(Config.dateFormats.DISPLAY_APPLICATION_START_END_DATE.getFormatter()));
            amtDueLabel.setText(paymentDetails.getTotalAmtDueString(Config.CURRRENCY));
            totalAmtPayableLabel.setText(paymentDetails.getAmtPayableString(Config.CURRRENCY));            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        overviewPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        roomNumLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        servicingLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        checkInDateLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        checkOutDateLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        applicationStatusLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        paymentStatusLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dueDateLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        amtDueLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        totalAmtPayableLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        paymentBtn = new javax.swing.JToggleButton();
        reApplyBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(930, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Overview");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 38));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 1040, 10));

        overviewPanel.setBackground(new java.awt.Color(255, 255, 255));
        overviewPanel.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Room Number");

        roomNumLabel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        roomNumLabel.setForeground(new java.awt.Color(0, 0, 0));
        roomNumLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(roomNumLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(roomNumLabel)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Servicing");

        servicingLabel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        servicingLabel.setForeground(new java.awt.Color(0, 0, 0));
        servicingLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(servicingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(servicingLabel)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Check-in Date");

        checkInDateLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        checkInDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        checkInDateLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(checkInDateLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(checkInDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Check-out Date");

        checkOutDateLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        checkOutDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        checkOutDateLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(checkOutDateLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(checkOutDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Application Status");

        applicationStatusLabel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        applicationStatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        applicationStatusLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(applicationStatusLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(applicationStatusLabel)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Room Type");

        roomTypeLabel.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        roomTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        String roomTypeName;
        if (HostelST.getCurrentUserRoom() == null) {
            roomTypeName = "N/A";
        } else {
            roomTypeName = HostelST.getCurrentUserRoom().getRoomType().getTypeName();
            roomTypeName = roomTypeName.replaceAll("\\s", "");
        }
        roomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomTypeLabel.setText(Config.NOT_APPLICABLE);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(roomTypeLabel)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(roomTypeLabel)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        overviewPanel.add(jPanel7);

        add(overviewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 66, 650, 440));

        paymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 0, 10));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Payment Status");
        jPanel1.add(jLabel12);

        paymentStatusLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        paymentStatusLabel.setText(Config.NOT_APPLICABLE);
        jPanel1.add(paymentStatusLabel);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("Due Date");
        jPanel1.add(jLabel14);

        dueDateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dueDateLabel.setText(Config.NOT_APPLICABLE);
        jPanel1.add(dueDateLabel);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setText("Amount Due");
        jPanel1.add(jLabel19);

        amtDueLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amtDueLabel.setText(Config.NOT_APPLICABLE);
        jPanel1.add(amtDueLabel);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("<html>Total Amount <br/>Payable</html>");
        jPanel1.add(jLabel15);

        totalAmtPayableLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        totalAmtPayableLabel.setText(Config.NOT_APPLICABLE);
        jPanel1.add(totalAmtPayableLabel);

        paymentPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 320, 320));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usd-circle.png"))); // NOI18N
        jLabel13.setText("  Payment");
        paymentPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, -1));

        paymentBtn.setBackground(new java.awt.Color(0, 0, 0));
        paymentBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        paymentBtn.setText("Proceed to Payment");
        paymentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });
        paymentPanel.add(paymentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 363, 500));

        reApplyBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        reApplyBtn.setText("Re-apply");
        reApplyBtn.setToolTipText("");
        reApplyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reApplyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reApplyBtnActionPerformed(evt);
            }
        });
        add(reApplyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 120, 30));
        reApplyBtn.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        HostelST.showPayment();
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void reApplyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reApplyBtnActionPerformed
        HostelST.showRooms();
    }//GEN-LAST:event_reApplyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel amtDueLabel;
    private static javax.swing.JLabel applicationStatusLabel;
    private static javax.swing.JLabel checkInDateLabel;
    private static javax.swing.JLabel checkOutDateLabel;
    private static javax.swing.JLabel dueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel overviewPanel;
    private javax.swing.JToggleButton paymentBtn;
    private javax.swing.JPanel paymentPanel;
    private static javax.swing.JLabel paymentStatusLabel;
    private static javax.swing.JButton reApplyBtn;
    private static javax.swing.JLabel roomNumLabel;
    private static javax.swing.JLabel roomTypeLabel;
    private static javax.swing.JLabel servicingLabel;
    private static javax.swing.JLabel totalAmtPayableLabel;
    // End of variables declaration//GEN-END:variables
}
