/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import Models.Student;
import Utils.PopUpWindow;
import Utils.UserHandling;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author KZ
 */
public class BeforeApplyST extends javax.swing.JPanel {

    /**
     * Creates new form BeforeApplyST
     */
    public BeforeApplyST() {
        initComponents();
        if (HostelST.getCurrentUserApplication().getStatus().equals("Rejected")) {
            fillFields();
        }
    }

    private void fillFields() {
        jTextField1.setText(HostelST.getCurrentUser().getNationality().replace("_", " "));
        jTextField2.setText(HostelST.getCurrentUser().getRace().replace("_", " "));
        jTextField3.setText(HostelST.getCurrentUser().getReligion().replace("_", " "));
        jTextField4.setText(HostelST.getCurrentUser().getPermanentAddress().replace("_", " "));
        jTextField5.setText(HostelST.getCurrentUser().getMedicalCondition().replace("_", " "));
        jTextField6.setText(HostelST.getCurrentUser().getEmerContactName().replace("_", " "));
        jTextField7.setText(HostelST.getCurrentUser().getEmerContactRelationship().replace("_", " "));
        jTextField8.setText(HostelST.getCurrentUser().getEmerContactNo());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notAppliedPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        roomDetailsSection = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        studentDetailsSection = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        emerContactSection = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        warningLabel = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        notAppliedPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomDetailsSection.setBackground(new java.awt.Color(255, 255, 255));
        roomDetailsSection.setLayout(new java.awt.GridLayout(5, 2, 0, 30));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Room Details");
        roomDetailsSection.add(jLabel49);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        roomDetailsSection.add(jPanel1);

        jLabel48.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Room Type");
        roomDetailsSection.add(jLabel48);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText(HostelST.getSelectedRoomType());
        roomDetailsSection.add(jLabel4);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Room Number");
        roomDetailsSection.add(jLabel47);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(HostelST.getSelectedRoom().getRoomID());
        roomDetailsSection.add(jLabel2);

        jLabel56.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("<html>Start Date<font color='red'>*</font> (DD-MM-YYYY)</html>");
        roomDetailsSection.add(jLabel56);

        jTextField9.setBackground(new java.awt.Color(255, 255, 255));
        roomDetailsSection.add(jTextField9);

        jLabel57.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Period of Stay");
        roomDetailsSection.add(jLabel57);

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 year", "2 years", "3 years", "4 years", "5 years" }));
        roomDetailsSection.add(jComboBox1);

        jPanel2.add(roomDetailsSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 930, 270));

        studentDetailsSection.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.setLayout(new java.awt.GridLayout(11, 2, 0, 30));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Student Details");
        studentDetailsSection.add(jLabel50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        studentDetailsSection.add(jPanel3);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Full Name");
        studentDetailsSection.add(jLabel19);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(HostelST.getCurrentUser().getName().replace("_", " "));
        studentDetailsSection.add(jLabel5);

        jLabel35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Email");
        studentDetailsSection.add(jLabel35);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText(HostelST.getCurrentUser().getEmail());
        studentDetailsSection.add(jLabel6);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Gender");
        studentDetailsSection.add(jLabel21);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText(HostelST.getCurrentUser().getGender());
        studentDetailsSection.add(jLabel7);

        jLabel33.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("HP No");
        studentDetailsSection.add(jLabel33);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText(HostelST.getCurrentUser().getPhoneNo());
        studentDetailsSection.add(jLabel8);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("IC/Passport Number");
        studentDetailsSection.add(jLabel23);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(HostelST.getCurrentUser().getNRIC());
        studentDetailsSection.add(jLabel9);

        jLabel27.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("<html>Nationality<font color='red'>*</font></html>");
        studentDetailsSection.add(jLabel27);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.add(jTextField1);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Race");
        studentDetailsSection.add(jLabel29);

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.add(jTextField2);

        jLabel31.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Religion");
        studentDetailsSection.add(jLabel31);

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.add(jTextField3);

        jLabel37.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("<html>Permanent Address<font color='red'>*</font></html>");
        studentDetailsSection.add(jLabel37);

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.add(jTextField4);

        jLabel39.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Medical Condition (if any)");
        studentDetailsSection.add(jLabel39);

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailsSection.add(jTextField5);

        jPanel2.add(studentDetailsSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 930, 630));

        emerContactSection.setBackground(new java.awt.Color(255, 255, 255));
        emerContactSection.setLayout(new java.awt.GridLayout(4, 2, 0, 30));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Emergency Contact");
        emerContactSection.add(jLabel51);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        emerContactSection.add(jPanel4);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setText("<html>Emergency Contact Name<font color='red'>*</font></html>");
        emerContactSection.add(jLabel44);

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        emerContactSection.add(jTextField6);

        jLabel43.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("<html>Emergency Contact Relationship<font color='red'>*</font></html>");
        emerContactSection.add(jLabel43);

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        emerContactSection.add(jTextField7);

        jLabel41.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("<html>Emergency Contact Number<font color='red'>*</font></html>");
        emerContactSection.add(jLabel41);

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        emerContactSection.add(jTextField8);

        jPanel2.add(emerContactSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 970, 930, 250));

        warningLabel.setText("<html><font color='red'>Please fill in all the required (*) fields</font></html>");
        jPanel2.add(warningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        scrollPane.setViewportView(jPanel2);

        confirmBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.setToolTipText("");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notAppliedPanelLayout = new javax.swing.GroupLayout(notAppliedPanel);
        notAppliedPanel.setLayout(notAppliedPanelLayout);
        notAppliedPanelLayout.setHorizontalGroup(
            notAppliedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notAppliedPanelLayout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(confirmBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(notAppliedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(notAppliedPanelLayout.createSequentialGroup()
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        notAppliedPanelLayout.setVerticalGroup(
            notAppliedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notAppliedPanelLayout.createSequentialGroup()
                .addContainerGap(470, Short.MAX_VALUE)
                .addComponent(confirmBtn)
                .addGap(35, 35, 35))
            .addGroup(notAppliedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(notAppliedPanelLayout.createSequentialGroup()
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 74, Short.MAX_VALUE)))
        );

        if (HostelST.getSelectedRoom() == null) {
            confirmBtn.setVisible(true);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(notAppliedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(notAppliedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean requiredFieldsValid() {
        boolean valid = true;
        
        if (jTextField9.getText().isBlank()) {
            valid = false;
        }
        if (jTextField1.getText().isBlank()) {
            valid = false;
        }
        if (jTextField4.getText().isBlank()) {
            valid = false;
        }
        if (jTextField6.getText().isBlank()) {
            valid = false;
        }
        if (jTextField7.getText().isBlank()) {
            valid = false;
        }
        if (jTextField8.getText().isBlank()) {
            valid = false;
        }
        
        return valid;
    }
    
    private static LocalDateTime getInputDate() {
        String startDateString = jTextField9.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(startDateString, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
        if (date.isBefore(LocalDate.now())) {
            return null;
        }
        return date.atTime(12, 0);
    }
    
    public static void confirmApplication() {
        ApplyTnCST.setStartDate(getInputDate());
        ApplyTnCST.setStayPeriod(jComboBox1.getSelectedIndex() + 1);
        Student student = HostelST.getCurrentUser();
        student.setNationality(jTextField1.getText());
        if (jTextField2.getText().isBlank()) {
            student.setRace("N/A");
        } else {
            student.setRace(jTextField2.getText());
        }
        if (jTextField3.getText().isBlank()) {
            student.setReligion("N/A");
        } else {
            student.setReligion(jTextField3.getText());
        }
        student.setPermanentAddress(jTextField4.getText());
        if (jTextField5.getText().isBlank()) {
            student.setMedicalCondition("N/A");
        } else {
            student.setMedicalCondition(jTextField5.getText());
        }
        student.setEmerContactName(jTextField6.getText());
        student.setEmerContactRelationship(jTextField7.getText());
        student.setEmerContactNo(jTextField8.getText());
        UserHandling.updateStudentDetail(student);
    }
    
    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        if (HostelST.getSelectedRoomType() == null) {
            PopUpWindow.showErrorMessage("Please select a room type in the Rooms page first.", "Error");
            HostelST.showRooms();
        } else if (requiredFieldsValid() == false) {
            PopUpWindow.showErrorMessage("Please fill in all the required(*) fields.", "Error");
        } else if (getInputDate() == null) {
            PopUpWindow.showErrorMessage("Invalid date or format.", "Error");
        } else {
            HostelST.showTnC();
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPanel emerContactSection;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel19;
    private static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    private static javax.swing.JTextField jTextField3;
    private static javax.swing.JTextField jTextField4;
    private static javax.swing.JTextField jTextField5;
    private static javax.swing.JTextField jTextField6;
    private static javax.swing.JTextField jTextField7;
    private static javax.swing.JTextField jTextField8;
    private static javax.swing.JTextField jTextField9;
    private javax.swing.JPanel notAppliedPanel;
    private javax.swing.JPanel roomDetailsSection;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel studentDetailsSection;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
