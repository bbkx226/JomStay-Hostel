// @author Brandon Ban Kai Xian TP067094
package DesignUI;

import Utils.PopUpWindow;
import javax.swing.JOptionPane;

public class ReportAD extends javax.swing.JFrame {

    /**
     * Creates new form ReportAD
     */
    public ReportAD() {
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

        jPanel3 = new javax.swing.JPanel();
        monthlyIncomeButton = new javax.swing.JPanel();
        monthlyIncomeImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        availableRoomsButton = new javax.swing.JPanel();
        availableRoomsImg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hostelIcon = new javax.swing.JLabel();
        applicationIcon = new javax.swing.JLabel();
        students = new javax.swing.JLabel();
        reportsIcon = new javax.swing.JLabel();
        signoutIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generate Reports");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        monthlyIncomeButton.setBackground(new java.awt.Color(153, 153, 255));
        monthlyIncomeButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        monthlyIncomeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        monthlyIncomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthlyIncomeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monthlyIncomeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monthlyIncomeButtonMouseExited(evt);
            }
        });

        monthlyIncomeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cash.png"))); // NOI18N
        monthlyIncomeImg.setToolTipText("");
        monthlyIncomeImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthlyIncomeImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monthlyIncomeImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monthlyIncomeImgMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Monthly Income");

        javax.swing.GroupLayout monthlyIncomeButtonLayout = new javax.swing.GroupLayout(monthlyIncomeButton);
        monthlyIncomeButton.setLayout(monthlyIncomeButtonLayout);
        monthlyIncomeButtonLayout.setHorizontalGroup(
            monthlyIncomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthlyIncomeButtonLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
            .addGroup(monthlyIncomeButtonLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(monthlyIncomeImg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        monthlyIncomeButtonLayout.setVerticalGroup(
            monthlyIncomeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthlyIncomeButtonLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(monthlyIncomeImg)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        availableRoomsButton.setBackground(new java.awt.Color(153, 153, 255));
        availableRoomsButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        availableRoomsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        availableRoomsButton.setPreferredSize(new java.awt.Dimension(231, 191));
        availableRoomsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableRoomsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                availableRoomsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                availableRoomsButtonMouseExited(evt);
            }
        });

        availableRoomsImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/room.png"))); // NOI18N
        availableRoomsImg.setToolTipText("");
        availableRoomsImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableRoomsImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                availableRoomsImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                availableRoomsImgMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Available Rooms");

        javax.swing.GroupLayout availableRoomsButtonLayout = new javax.swing.GroupLayout(availableRoomsButton);
        availableRoomsButton.setLayout(availableRoomsButtonLayout);
        availableRoomsButtonLayout.setHorizontalGroup(
            availableRoomsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableRoomsButtonLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(availableRoomsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, availableRoomsButtonLayout.createSequentialGroup()
                        .addComponent(availableRoomsImg)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, availableRoomsButtonLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32))))
        );
        availableRoomsButtonLayout.setVerticalGroup(
            availableRoomsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableRoomsButtonLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(availableRoomsImg)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setText("Generate Report");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(monthlyIncomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291)
                .addComponent(availableRoomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(542, 542, 542))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(99, 99, 99)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthlyIncomeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableRoomsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        hostelIcon.setBackground(new java.awt.Color(153, 153, 255));
        hostelIcon.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        hostelIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hostel.png"))); // NOI18N
        hostelIcon.setText("Rooms");
        hostelIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hostelIcon.setOpaque(true);
        hostelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostelIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hostelIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hostelIconMouseExited(evt);
            }
        });

        applicationIcon.setBackground(new java.awt.Color(153, 153, 255));
        applicationIcon.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        applicationIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        applicationIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/application.png"))); // NOI18N
        applicationIcon.setText("Application");
        applicationIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        applicationIcon.setOpaque(true);
        applicationIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                applicationIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                applicationIconMouseExited(evt);
            }
        });

        students.setBackground(new java.awt.Color(153, 153, 255));
        students.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        students.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        students.setText("Students");
        students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        students.setOpaque(true);
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentsMouseExited(evt);
            }
        });

        reportsIcon.setBackground(new java.awt.Color(102, 102, 255));
        reportsIcon.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        reportsIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seo-report.png"))); // NOI18N
        reportsIcon.setText("Reports");
        reportsIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsIcon.setOpaque(true);

        signoutIcon.setBackground(new java.awt.Color(153, 153, 255));
        signoutIcon.setFont(new java.awt.Font("Baskerville Old Face", 1, 20)); // NOI18N
        signoutIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/log-out.png"))); // NOI18N
        signoutIcon.setText("Sign out");
        signoutIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signoutIcon.setOpaque(true);
        signoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signoutIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signoutIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signoutIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(hostelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applicationIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(applicationIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(hostelIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(signoutIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutIconMouseClicked
        int dialogResult = JOptionPane.showConfirmDialog(
            null,
            "Are you ready to sign out?",
            "Popup window",
            JOptionPane.YES_NO_OPTION
        );
        if (dialogResult == JOptionPane.YES_OPTION){
            PopUpWindow.showGoodByeMessage("Thanks for using the system, have a nice day~", "Goodbye~");
            setVisible(false);
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_signoutIconMouseClicked

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked
        dispose();
        new RecordAD().setVisible(true);
    }//GEN-LAST:event_studentsMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void monthlyIncomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeButtonMouseClicked
        new MonthlyIncome().start();
    }//GEN-LAST:event_monthlyIncomeButtonMouseClicked

    private void availableRoomsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsButtonMouseClicked
        new AvailableRoom().start();
    }//GEN-LAST:event_availableRoomsButtonMouseClicked

    private void monthlyIncomeImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeImgMouseClicked
        new MonthlyIncome().start();
    }//GEN-LAST:event_monthlyIncomeImgMouseClicked

    private void availableRoomsImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsImgMouseClicked
        new AvailableRoom().start();
    }//GEN-LAST:event_availableRoomsImgMouseClicked

    private void hostelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostelIconMouseClicked
        dispose();
        new HostelAD().start();
    }//GEN-LAST:event_hostelIconMouseClicked

    private void hostelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostelIconMouseEntered
        hostelIcon.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_hostelIconMouseEntered

    private void hostelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostelIconMouseExited
        hostelIcon.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_hostelIconMouseExited

    private void applicationIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationIconMouseClicked
        dispose();
        new ApplicationAD().start();
    }//GEN-LAST:event_applicationIconMouseClicked

    private void applicationIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationIconMouseEntered
        applicationIcon.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_applicationIconMouseEntered

    private void applicationIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationIconMouseExited
        applicationIcon.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_applicationIconMouseExited

    private void signoutIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutIconMouseEntered
        signoutIcon.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_signoutIconMouseEntered

    private void signoutIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutIconMouseExited
        signoutIcon.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_signoutIconMouseExited

    private void studentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseEntered
        students.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_studentsMouseEntered

    private void studentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseExited
        students.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_studentsMouseExited

    private void monthlyIncomeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeButtonMouseEntered
        monthlyIncomeButton.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_monthlyIncomeButtonMouseEntered

    private void monthlyIncomeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeButtonMouseExited
        monthlyIncomeButton.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_monthlyIncomeButtonMouseExited

    private void availableRoomsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsButtonMouseEntered
        availableRoomsButton.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_availableRoomsButtonMouseEntered

    private void availableRoomsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsButtonMouseExited
        availableRoomsButton.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_availableRoomsButtonMouseExited

    private void monthlyIncomeImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeImgMouseEntered
        monthlyIncomeButton.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_monthlyIncomeImgMouseEntered

    private void monthlyIncomeImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthlyIncomeImgMouseExited
        monthlyIncomeButton.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_monthlyIncomeImgMouseExited

    private void availableRoomsImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsImgMouseEntered
        availableRoomsButton.setBackground(new java.awt.Color(173, 216, 230));
    }//GEN-LAST:event_availableRoomsImgMouseEntered

    private void availableRoomsImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableRoomsImgMouseExited
        availableRoomsButton.setBackground(new java.awt.Color(153, 153, 255));
    }//GEN-LAST:event_availableRoomsImgMouseExited

    public void start() {
        new ReportAD().setVisible(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReportAD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applicationIcon;
    private javax.swing.JPanel availableRoomsButton;
    private javax.swing.JLabel availableRoomsImg;
    private javax.swing.JLabel hostelIcon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel monthlyIncomeButton;
    private javax.swing.JLabel monthlyIncomeImg;
    private javax.swing.JLabel reportsIcon;
    private javax.swing.JLabel signoutIcon;
    private javax.swing.JLabel students;
    // End of variables declaration//GEN-END:variables
}
