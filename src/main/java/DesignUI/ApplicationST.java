/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DesignUI;

import Utils.PopUpWindow;
import java.awt.CardLayout;

/**
 *
 * @author KZ
 */
public class ApplicationST extends javax.swing.JPanel {
    
    private static CardLayout card;
    
    /**
     * Creates new form ApplicationST
     */
    public ApplicationST() {
        initComponents();
        card = (CardLayout) contentPanel.getLayout();
        if (HostelST.getCurrentUserRoom() == null) {
            showNotAppliedPage();
        } else {
            showAppliedPage();
        }
    }
    
    private static void showNotAppliedPage() {
        BeforeApplyST notAppliedPanel = new BeforeApplyST();
        contentPanel.add(notAppliedPanel, "not applied");
        card.show(contentPanel, "not applied");
    }
    
    private static void showAppliedPage() {
        AfterApplyST appliedPanel = new AfterApplyST();
        contentPanel.add(appliedPanel, "applied");
        card.show(contentPanel, "applied");
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
        jSeparator3 = new javax.swing.JSeparator();
        contentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Apply");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1058, 10));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new java.awt.CardLayout());
        add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1050, 510));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
