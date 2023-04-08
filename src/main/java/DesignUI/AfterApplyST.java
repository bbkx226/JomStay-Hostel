/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class AfterApplyST extends javax.swing.JPanel {

    private static String dateCreatedString;
    private static String dateStartedString;
    private static String dateEndedString;
    
    /**
     * Creates new form AfterApplyST
     */
    public AfterApplyST() {
        initData();
        initComponents();
    }
    
    private static void initData() {
        DateTimeFormatter getFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd?HH:mm");
        DateTimeFormatter setFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        LocalDateTime dateCreated = LocalDateTime.parse(HostelST.getCurrentUserApplication().getCreateDate(), getFormatter);
        LocalDateTime dateStarted = LocalDateTime.parse(HostelST.getCurrentUserApplication().getStartDate(), getFormatter);
        LocalDateTime dateEnded = LocalDateTime.parse(HostelST.getCurrentUserApplication().getEndDate(), getFormatter);
        dateCreatedString = dateCreated.format(setFormatter);
        dateStartedString = dateStarted.format(setFormatter);
        dateEndedString = dateEnded.format(setFormatter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appliedPanel = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        appliedPanel.setBackground(new java.awt.Color(255, 255, 255));
        appliedPanel.setLayout(new java.awt.GridLayout(8, 2, 0, 30));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Application Details");
        appliedPanel.add(jLabel58);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        appliedPanel.add(jPanel7);

        jLabel53.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Status");
        appliedPanel.add(jLabel53);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(HostelST.getCurrentUserApplication().getStatus());
        if (jLabel10.getText().equals("Pending")) {
            jLabel10.setForeground(Color.BLUE);
        } else if (jLabel10.getText().equals("Rejected")) {
            jLabel10.setForeground(Color.RED);
        } else {
            jLabel10.setForeground(Color.GREEN);
        }
        appliedPanel.add(jLabel10);

        jLabel61.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Application Date");
        appliedPanel.add(jLabel61);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText(dateCreatedString);
        if (jLabel10.getText().equals("Pending")) {
            jLabel10.setForeground(Color.BLUE);
        } else if (jLabel10.getText().equals("Rejected")) {
            jLabel10.setForeground(Color.RED);
        } else {
            jLabel10.setForeground(Color.GREEN);
        }
        appliedPanel.add(jLabel15);

        jLabel59.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Check-In Date");
        appliedPanel.add(jLabel59);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText(dateStartedString);
        if (jLabel10.getText().equals("Pending")) {
            jLabel10.setForeground(Color.BLUE);
        } else if (jLabel10.getText().equals("Rejected")) {
            jLabel10.setForeground(Color.RED);
        } else {
            jLabel10.setForeground(Color.GREEN);
        }
        appliedPanel.add(jLabel13);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Check-Out Date");
        appliedPanel.add(jLabel60);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText(dateEndedString);
        if (jLabel10.getText().equals("Pending")) {
            jLabel10.setForeground(Color.BLUE);
        } else if (jLabel10.getText().equals("Rejected")) {
            jLabel10.setForeground(Color.RED);
        } else {
            jLabel10.setForeground(Color.GREEN);
        }
        appliedPanel.add(jLabel14);

        jLabel52.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setText("Room Details");
        appliedPanel.add(jLabel52);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        appliedPanel.add(jPanel6);

        jLabel54.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Room Number");
        appliedPanel.add(jLabel54);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText(HostelST.getCurrentUserRoom().getRoomID());
        appliedPanel.add(jLabel11);

        jLabel55.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Room Type");
        appliedPanel.add(jLabel55);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("TODO: Admin add RoomType to rooms.txt");
        appliedPanel.add(jLabel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(appliedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(appliedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appliedPanel;
    private static javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel jLabel11;
    private static javax.swing.JLabel jLabel12;
    private static javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
