/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import Models.Application;
import Models.Room;
import Utils.Config;
import java.awt.Color;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class AfterApplyST extends javax.swing.JPanel {

    /**
     * Creates new form AfterApplyST
     */
    public AfterApplyST() {
        initComponents();
        setLabels();
    }

    private static void setLabels() {
        Application application = HostelST.getCurrentUserApplication();
        Room room = HostelST.getCurrentUserRoom();
        DateTimeFormatter createDateFormatter = Config.dateFormats.DISPLAY_APPLICATION_CREATE_DATE.getFormatter();
        DateTimeFormatter dateFormatter = Config.dateFormats.DISPLAY_APPLICATION_START_DATE.getFormatter();

        statusLabel.setText(application.getStatus());
        switch (statusLabel.getText()) {
            case "Pending" ->
                statusLabel.setForeground(Color.BLUE);
            case "Rejected" ->
                statusLabel.setForeground(Color.RED);
            case "Accepted" ->
                statusLabel.setForeground(Color.GREEN);
            default ->
                statusLabel.setForeground(Color.BLACK);
        }
        applicationDateLabel.setText(application.getLocalCreateDate().format(createDateFormatter));
        checkInDateLabel.setText(application.getLocalStartDate().format(dateFormatter));
        checkOutDateLabel.setText(application.getLocalEndDate().format(dateFormatter));
        roomNumLabel.setText(room.getRoomID());
        roomTypeLabel.setText(room.getRoomType().getTypeName());
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
        statusLabel = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        applicationDateLabel = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        checkInDateLabel = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        checkOutDateLabel = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        roomNumLabel = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();

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

        statusLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(0, 0, 0));
        statusLabel.setText(Config.NOT_APPLICABLE);
        if (statusLabel.getText().equals("Pending")) {
            statusLabel.setForeground(Color.BLUE);
        } else if (statusLabel.getText().equals("Rejected")) {
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setForeground(Color.GREEN);
        }
        appliedPanel.add(statusLabel);

        jLabel61.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Application Date");
        appliedPanel.add(jLabel61);

        applicationDateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        applicationDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        applicationDateLabel.setText(Config.NOT_APPLICABLE);
        if (statusLabel.getText().equals("Pending")) {
            statusLabel.setForeground(Color.BLUE);
        } else if (statusLabel.getText().equals("Rejected")) {
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setForeground(Color.GREEN);
        }
        appliedPanel.add(applicationDateLabel);

        jLabel59.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Check-In Date");
        appliedPanel.add(jLabel59);

        checkInDateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        checkInDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        checkInDateLabel.setText(Config.NOT_APPLICABLE);
        if (statusLabel.getText().equals("Pending")) {
            statusLabel.setForeground(Color.BLUE);
        } else if (statusLabel.getText().equals("Rejected")) {
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setForeground(Color.GREEN);
        }
        appliedPanel.add(checkInDateLabel);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Check-Out Date");
        appliedPanel.add(jLabel60);

        checkOutDateLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        checkOutDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        checkOutDateLabel.setText(Config.NOT_APPLICABLE);
        if (statusLabel.getText().equals("Pending")) {
            statusLabel.setForeground(Color.BLUE);
        } else if (statusLabel.getText().equals("Rejected")) {
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setForeground(Color.GREEN);
        }
        appliedPanel.add(checkOutDateLabel);

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

        roomNumLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roomNumLabel.setForeground(new java.awt.Color(0, 0, 0));
        roomNumLabel.setText(Config.NOT_APPLICABLE);
        appliedPanel.add(roomNumLabel);

        jLabel55.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Room Type");
        appliedPanel.add(jLabel55);

        roomTypeLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roomTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        roomTypeLabel.setText(Config.NOT_APPLICABLE);
        appliedPanel.add(roomTypeLabel);

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
            .addGap(0, 566, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(appliedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel applicationDateLabel;
    private javax.swing.JPanel appliedPanel;
    private static javax.swing.JLabel checkInDateLabel;
    private static javax.swing.JLabel checkOutDateLabel;
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
    private static javax.swing.JLabel roomNumLabel;
    private static javax.swing.JLabel roomTypeLabel;
    private static javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
