/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import Models.Application;
import Utils.ApplicationHandling;
import static Utils.ApplicationHandling.totalApplications;
import Utils.PopUpWindow;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class ApplyTnCST extends javax.swing.JPanel {

    private static LocalDateTime startDate;
    private static int stayPeriod;

    /**
     * Creates new form ApplyTnCST
     */
    public ApplyTnCST() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        confirmBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Terms and Conditions");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("<html>2. I declare that the particulars in this application form are true to the best of my knowledge, and I have not<br/>wilfully suppressed any material fact. Any misrepresentation or omission of information will render me ineligible<br/>for student accommodation.<html/>");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("<html>2. Booking confirmations by payment equivalent to one (1) month deposit and pro-rated rent up to the end<br/>of the month must be received by JomStay, failing which the<br/>JomStay will not be able to guarantee the accommodation requested. Thereafter, rent must be paid on a<br/>calendar month basis on or before the 7th day of each month.</html>");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("3. I undertake to abide by the Tenancy Agreement and Hostel Accommodation Code of Conduct.");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Declaration");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 465, 33));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("<html>3. All applicants are required to sign a tenancy agreement for a minimum period of one (1) academic year<br/>(12 months).<html/>");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("General Conditions");
        jPanel2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 465, 33));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("1. Rooms are allocated on a first-come-first-serve-basis.");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("1. I understand and accept the general conditions for booking of hostel accommodation.");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setText("I have read and agreed to the Terms and Conditions");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        confirmBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        confirmBtn.setText("Confirm Application");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(confirmBtn)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void setStartDate(LocalDateTime startDate) {
        ApplyTnCST.startDate = startDate;
    }

    public static void setStayPeriod(int stayPeriod) {
        ApplyTnCST.stayPeriod = stayPeriod;
    }

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        if (!jCheckBox1.isSelected()) {
            PopUpWindow.showErrorMessage("Please ensure that you have agreed to the Terms and Conditions as stated by checking the checkbox.", "Error");
        } else {
            BeforeApplyST.confirmApplication();
            
            String newApplicationID = String.format("A%03d", totalApplications.size() + 1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
            String createDate = LocalDateTime.now().format(formatter);

            String startDateString = startDate.format(formatter);
            LocalDateTime endDate = startDate.plusYears(stayPeriod);
            String endDateString = endDate.format(formatter);

            Application application = new Application(
                    newApplicationID,
                    HostelST.getCurrentUser(),
                    HostelST.getSelectedRoom(),
                    "Pending", createDate,
                    startDateString,
                    endDateString);
            ApplicationHandling.addNewApplication(application);
            HostelST.setCurrentUserApplication(application);
            HostelST.setCurrentUserRoom(HostelST.getSelectedRoom());
            
            PopUpWindow.showSuccessfulMessage("Application has been sent to JomStay. We will get back to you when your application has been checked and accepted.", "Success");
            HostelST.showApplication();

        }
    }//GEN-LAST:event_confirmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
