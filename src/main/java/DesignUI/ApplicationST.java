package DesignUI;

import java.awt.CardLayout;

/**
 *
 * @author KZ
 */
public class ApplicationST extends javax.swing.JPanel {
    
    /**
     * Creates new form ApplicationST
     */
    public ApplicationST() {
        initComponents();
        CardLayout card = (CardLayout) contentPanel.getLayout();
        // shows the application panel according to whether the currently logged in student has applied for a room or not
        if (HostelST.getCurrentUserRoom() == null
                || HostelST.getCurrentUserApplication().getStatus().equals("Rejected")) {
            contentPanel.add(new BeforeApplyST(), "not applied");
            card.show(contentPanel, "not applied");
        } else {
            contentPanel.add(new AfterApplyST(), "applied");
            card.show(contentPanel, "applied");
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
