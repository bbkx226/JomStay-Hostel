/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DesignUI;

/**
 *
 * @author KZ
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ReceiptGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final LinkedHashMap<String, String> DATA;
    private final JTextArea RECEIPT_TEXT_AREA;

    private Runnable onClose;

    public static JButton confirmButton;
    
    public ReceiptGUI(LinkedHashMap<String, String> data, Runnable onClose) {
        super("Hostel Rental Receipt");
        this.DATA = data;
        this.onClose = onClose;

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        RECEIPT_TEXT_AREA = new JTextArea(10, 40);
        RECEIPT_TEXT_AREA.setEditable(false);
        RECEIPT_TEXT_AREA.setLineWrap(true);
        RECEIPT_TEXT_AREA.setWrapStyleWord(true);
        RECEIPT_TEXT_AREA.setText(generateReceiptText());

        contentPane.add(RECEIPT_TEXT_AREA, BorderLayout.CENTER);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        
        JButton printButton = new JButton("Print Receipt");
        printButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        buttonPanel.add(printButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        
        // Add a WindowListener to the JFrame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Call the onClose runnable
                onClose.run();
            }
        });
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            dispose(); // Exit the window
        } else if (e.getActionCommand().equals("Print Receipt")) {
            System.out.println("Printing receipt...");
        }
    }

    private String generateReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hostel Rental Receipt\n");
        sb.append("=======================\n\n");
        for (Entry<String, String> entry : DATA.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}