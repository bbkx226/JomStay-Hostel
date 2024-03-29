package DesignUI;

import Models.Application;
import Models.Payment;
import Models.Payment.PaymentStatus;
import Utils.ApplicationPaymentDetails;
import Utils.Config;
import Utils.LogHandling;
import Utils.PaymentHandling;
import Utils.PopUpWindow;
import Utils.Validator;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author KZ
 */
public class PaymentST extends javax.swing.JPanel {

    private static final String FORMAT = Config.dateFormats.PAYMENT_RENT_PERIOD.getFormat();

    private static double selectedAmt;
    private static ArrayList<Integer> selectedMonths;
    private static ArrayList<Payment> payments;
    private static Application application;
    private static ApplicationPaymentDetails paymentDetails;
    
    /**
     * Creates new form PaymentST
     */
    public PaymentST() {
        initData();
        initComponents();
        initTable();
    }
    
    // initialize data to show in GUI
    private static void initData() {
        selectedAmt = 0;
        selectedMonths = new ArrayList<>();
        application = HostelST.getCurrentUserApplication();
        payments = PaymentHandling.getApplicationPayments(application);
        paymentDetails = HostelST.getCurrentPaymentDetails();
    }
    
    // class that implements the TableCellRenderer and extends JCheckbox to render the checkboxes in the table
    private class CheckboxCellRenderer extends JCheckBox implements TableCellRenderer {
        private final int disabledColumn;
        private final String disabledString;
        
        CheckboxCellRenderer(int disabledColumn, String disabledString) {
            this.disabledColumn = disabledColumn;
            this.disabledString = disabledString;
            setHorizontalAlignment(JCheckBox.CENTER);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            boolean isEnabled = !table.getValueAt(row, disabledColumn).toString().equals(disabledString);
            setSelected((Boolean) value);
            setEnabled(isEnabled);
            return this;
        }
    }
    
    // class that implements TableCellEditor and extends CheckboxCellEditor to allow the checkboxes to be ticked in the table
    private class CheckboxCellEditor extends AbstractCellEditor implements TableCellEditor {
        private final int disabledColumn;
        private final String disabledString;
        private final JCheckBox checkBox;
        
        CheckboxCellEditor(int disabledColumn, String disabledString) {
            this.disabledColumn = disabledColumn;
            this.disabledString = disabledString;
            
            checkBox = new JCheckBox();
            checkBox.setHorizontalAlignment(JCheckBox.CENTER);
            checkBox.addItemListener((ItemEvent e) -> {
                fireEditingStopped();
            });
        }
        @Override
        public Object getCellEditorValue() {
            return checkBox.isSelected();
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            boolean isEnabled = !table.getValueAt(row, disabledColumn).toString().equals(disabledString);
            checkBox.setSelected((Boolean) value);
            checkBox.setEnabled(isEnabled);
            return checkBox;
        }
    }
   
    // class that extends DefaultTableCellRenderer to change the color of the text under the status column according to the text in another column
    private class PaymentStatusColorCellRenderer extends DefaultTableCellRenderer {
        private final int column;

        public PaymentStatusColorCellRenderer(int column) {
            this.column = column;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == this.column && value instanceof String) {
                String text = (String) value;
                if (text.contains("Paid")) {
                    component.setForeground(Color.GREEN);
                } else if (text.contains("Pending")) {
                    component.setForeground(Color.BLUE);
                } else {
                    component.setForeground(Color.RED);
                }
            }
            return component;
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
        resetBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        rentMonthsLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rentalPeriodLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        selectedAmtLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        payBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Payment");

        resetBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        resetBtn.setText("Clear Selection");
        resetBtn.setToolTipText("");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        paymentTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        paymentTable.setForeground(new java.awt.Color(0, 0, 0));
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Month", "Rent Period", "Amount", "Due Date", "Status", "Method", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(paymentTable);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 0, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("    Rental Months");
        jPanel2.add(jLabel13);

        rentMonthsLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rentMonthsLabel.setForeground(new java.awt.Color(255, 255, 255));
        rentMonthsLabel.setText("" + selectedMonths.size());
        jPanel2.add(rentMonthsLabel);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("    Rental Period");
        jPanel2.add(jLabel14);

        rentalPeriodLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rentalPeriodLabel.setForeground(new java.awt.Color(255, 255, 255));
        rentalPeriodLabel.setText("N/A");
        jPanel2.add(rentalPeriodLabel);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("    Total Amount");
        jPanel2.add(jLabel12);

        selectedAmtLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        selectedAmtLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedAmtLabel.setText("RM" + selectedAmt);
        jPanel2.add(selectedAmtLabel);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Choose the rent months from the table provided, but avoid rapid checkbox clicks to avoid data errors.");

        payBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        payBtn.setText("Pay Now");
        payBtn.setToolTipText("");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(resetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payBtn)
                        .addGap(427, 427, 427)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBtn)
                    .addComponent(payBtn))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // display the data in the panel on the right of the table
    private void showDataInPanel() {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        selectedAmtLabel.setText(Config.CURRRENCY + formatter.format(selectedAmt));
        rentMonthsLabel.setText("" + selectedMonths.size());
                
        Collections.sort(selectedMonths);
        if (selectedMonths.isEmpty()) {
            rentalPeriodLabel.setText(Config.NOT_APPLICABLE);
        } else {
            int firstSelectedMonth = selectedMonths.get(0);
            int lastSelectedMonth = selectedMonths.get(selectedMonths.size() - 1);
            String rentStart = (String) paymentTable.getValueAt(firstSelectedMonth - 1, 2);
            rentStart = rentStart.split(" ")[0];
            String rentEnd = (String) paymentTable.getValueAt(lastSelectedMonth - 1, 2);
            rentEnd = rentEnd.split("~ ")[1];
            rentalPeriodLabel.setText("<html>" + rentStart + "<br/> ~ <br/>" + rentEnd + "<html/>");
        }
    }
    
    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        resetAll();
    }//GEN-LAST:event_resetBtnActionPerformed
    
    // clear all the selections in the table and reset the values in the right panel
    private void resetAll() {
        DefaultTableModel tableModel = (DefaultTableModel) paymentTable.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(false, i, 0);
        }
        selectedAmt = 0;
        selectedMonths.clear();
        showDataInPanel();
    }
    
    // initialize the table and display its contents
    private void initTable() {
        DefaultTableModel tableModel = (DefaultTableModel) paymentTable.getModel();
        paymentTable.setRowSelectionAllowed(false);
        ArrayList<String> rentalPeriods = paymentDetails.getStringRentalPeriods(FORMAT);
        if (rentalPeriods.isEmpty()) {
            return;
        }
        ArrayList<String> dueDates = paymentDetails.getStringDueDates(FORMAT);
        
        for (int i = 0; i < payments.size(); i++) {
            Payment payment = payments.get(i);
            Object [] row = {
                false,
                i + 1,
                rentalPeriods.get(i),
                payment.getAmount(),
                dueDates.get(i),
                payment.getStatus().getStatusString(),
                payment.getMethod().replace("_", " "),
                payment.getDate()
            };
            tableModel.addRow(row);
        }
        
        TableColumnModel columnModel = paymentTable.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(new CheckboxCellRenderer(5, PaymentStatus.PAID.getStatusString()));
        columnModel.getColumn(0).setCellEditor(new CheckboxCellEditor(5, PaymentStatus.PAID.getStatusString()));
        columnModel.getColumn(5).setCellRenderer(new PaymentStatusColorCellRenderer(5));
        
        tableModel.addTableModelListener(event -> {
            int row = event.getFirstRow();
            String status = (String) paymentTable.getValueAt(row, 5);
            if (event.getColumn() == 0 && ! status.equals(PaymentStatus.PAID.getStatusString())) {
                boolean isSelected = (boolean) paymentTable.getValueAt(row, 0);
                if (isSelected) {
                    selectedAmt += (double) paymentTable.getValueAt(row, 3);
                    selectedMonths.add((Integer) paymentTable.getValueAt(row, 1));
                } else {
                    selectedAmt -= (double) paymentTable.getValueAt(row, 3);
                    selectedMonths.remove((Integer) paymentTable.getValueAt(row, 1));
                }
                showDataInPanel();
            }
        });

        for (int i = 0; i < paymentTable.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            switch (i) {
                case 0 -> column.setMinWidth(40);
                case 1 -> column.setMinWidth(35);
                case 2 -> column.setMinWidth(145);
                case 6 -> column.setMinWidth(50);
                default -> column.setMinWidth(60);
            }
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(6).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);
    }
            
    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        if (! Validator.validatePaymentTableSelection(payments, paymentTable, selectedMonths, selectedAmt)) {
            PopUpWindow.showErrorMessage("Invalid selection.", "Error");
            resetAll();
        } else {
            String paymentMethodInput = PopUpWindow.getPaymentMethod();
            if (paymentMethodInput != null) {
                PaymentHandling.updatePaymentFile(payments, selectedMonths, paymentMethodInput.replace(" ", "_"));
                // remove html tags
                String rentalPeriod = rentalPeriodLabel.getText().replaceAll("<[^>]*>", "");
                LogHandling.writeLog("User Payment", HostelST.getCurrentUser().getID());
                HostelST.proceedWithPayment(rentalPeriod, selectedAmt);
            } else {
                HostelST.showPayment();
            }
        }
    }//GEN-LAST:event_payBtnActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton payBtn;
    private javax.swing.JTable paymentTable;
    private javax.swing.JLabel rentMonthsLabel;
    private static javax.swing.JLabel rentalPeriodLabel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel selectedAmtLabel;
    // End of variables declaration//GEN-END:variables
}