/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DesignUI;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import Models.*;
import Utils.*;
import java.awt.CardLayout;
import java.time.LocalDateTime;
import javax.swing.JPanel;

/**
 *
 * @author bbkx2
 */
public class HostelST extends javax.swing.JFrame {

    /**
     * Creates new form HostelST
     */
    private static HomeST homePanel = new HomeST();
    private static RoomsST roomsPanel = new RoomsST();
    private static CardLayout card;
    
    // custom component properties
    Color btnBgColor = new Color(0,0,0);
    Color btnHoverColor = new Color(43, 43, 43);
    
    Border margin = new EmptyBorder(10, 10, 10, 10);
    CompoundBorder btnMarginBorder = new CompoundBorder(null, margin);
    
    private static ArrayList<Application> applications = new ApplicationHandling().totalApplications;
    private static Student currentUser = Login.getCurrentUser();
    private static Application currentUserApplication = null;
    private static Room currentUserRoom = null;
    
    public HostelST() {
        initComponents();
        card = (CardLayout) mainPanel.getLayout();
        mainPanel.add(homePanel, "home");
        mainPanel.add(roomsPanel, "rooms");
        card.show(mainPanel, "home");
    }
    
    public static Application getCurrentUserApplication() {
        return currentUserApplication;
    }
    
    public static Room getCurrentUserRoom() {
        return currentUserRoom;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        sidePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        homeBtn = new javax.swing.JToggleButton();
        roomsBtn = new javax.swing.JToggleButton();
        paymentBtn = new javax.swing.JToggleButton();
        profileBtn = new javax.swing.JToggleButton();
        homeBtn4 = new javax.swing.JToggleButton();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setBackground(new java.awt.Color(0, 0, 0));
        sidePanel.setForeground(new java.awt.Color(255, 255, 255));
        sidePanel.setLayout(new java.awt.GridLayout(6, 1, 0, 50));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/jomstaybg_small.png"))); // NOI18N
        sidePanel.add(logo);

        homeBtn.setBackground(new java.awt.Color(0, 0, 0));
        homeBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/house-chimney.png"))); // NOI18N
        homeBtn.setText("   Home           ");
        homeBtn.setBorder(btnMarginBorder);
        homeBtn.setBorderPainted(false);
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

        paymentBtn.setBackground(new java.awt.Color(0, 0, 0));
        paymentBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        paymentBtn.setForeground(new java.awt.Color(255, 255, 255));
        paymentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/dollar.png"))); // NOI18N
        paymentBtn.setText("   Payment     ");
        paymentBtn.setBorder(btnMarginBorder);
        paymentBtn.setBorderPainted(false);
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

        profileBtn.setBackground(new java.awt.Color(0, 0, 0));
        profileBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        profileBtn.setText("   Profile        ");
        profileBtn.setBorder(btnMarginBorder);
        profileBtn.setBorderPainted(false);
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

        homeBtn4.setBackground(new java.awt.Color(0, 0, 0));
        homeBtn4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        homeBtn4.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/exit.png"))); // NOI18N
        homeBtn4.setText("   Sign Out     ");
        homeBtn4.setBorder(btnMarginBorder);
        homeBtn4.setBorderPainted(false);
        homeBtn4.setRequestFocusEnabled(false);
        homeBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtn4Hover(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtn4ExitHover(evt);
            }
        });
        homeBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtn4ActionPerformed(evt);
            }
        });
        sidePanel.add(homeBtn4);

        jSplitPane1.setLeftComponent(sidePanel);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel1, "card2");

        jSplitPane1.setRightComponent(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        card.show(mainPanel, "home");
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
        card.show(mainPanel, "rooms");
    }//GEN-LAST:event_roomsBtnActionPerformed

    private void paymentBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnHover
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnHover

    private void paymentBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnExitHover
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnExitHover

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void profileBtnHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnHover
        // TODO add your handling code here:
    }//GEN-LAST:event_profileBtnHover

    private void profileBtnExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnExitHover
        // TODO add your handling code here:
    }//GEN-LAST:event_profileBtnExitHover

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileBtnActionPerformed

    private void homeBtn4Hover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtn4Hover
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtn4Hover

    private void homeBtn4ExitHover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtn4ExitHover
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtn4ExitHover

    private void homeBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBtn4ActionPerformed
    public void start() {
        LocalDateTime currentTime = LocalDateTime.now();
        for (Application application : applications) {
            if (currentTime.isAfter(application.getLocalEndDate())) {
                continue;
            }
            if (application.getStudent().getID().equals(currentUser.getID())) {
                currentUserApplication = application;
                currentUserRoom = application.getRoom();
            }
        }
        if (currentUserRoom == null) {
            System.out.println("You have no room");
        }
        Splash screen = new Splash();
        screen.setVisible(true);
        screen.dispose();
        new HostelST().setVisible(true);
    }
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
    private javax.swing.JToggleButton homeBtn;
    private javax.swing.JToggleButton homeBtn4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel logo;
    private static javax.swing.JPanel mainPanel;
    private javax.swing.JToggleButton paymentBtn;
    private javax.swing.JToggleButton profileBtn;
    private javax.swing.JToggleButton roomsBtn;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
