/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author KZ
 */
public class DatePicker extends JFrame {
    private static final String[] daysOfWeek = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    private static final String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };
    private static final int CALROWS = 6;
    private static final int CALCOLS = 7;
    private final Runnable ON_CLOSE;

    private int firstYear = 1990;
    private int lastYear = 2100;
    private static LocalDate currentDate = LocalDate.now();
    private static int firstDayOfWeek = currentDate.withDayOfMonth(1).getDayOfWeek().getValue();
    private static int daysInMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonthValue()).lengthOfMonth();
    private static LocalDate selectedDate = null;

    public DatePicker(Runnable onClose) {
        this.ON_CLOSE = onClose;
        initComponents();
        setVisible(true);
    }

    public DatePicker(int firstYear, int lastYear, Runnable onClose) {
        this.ON_CLOSE = onClose;
        this.firstYear = firstYear;
        this.lastYear = lastYear;
        initComponents();
        setVisible(true);
    }

    public static String getSelectedDateString(String format) {
        return selectedDate.format(DateTimeFormatter.ofPattern(format));
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        calendarPanel = new JPanel(new GridLayout(6, 7));
        bottomPanel = new JPanel(new FlowLayout());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        // top panel components
        dropDownListPanel = new JPanel(new FlowLayout());
        yearList = new JComboBox<>();
        for (int year = firstYear; year <= lastYear; year++) {
            yearList.addItem(year);
        }
        yearList.setSelectedItem(currentDate.getYear());
        yearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<Integer> source = (JComboBox<Integer>) e.getSource();
                currentDate = currentDate.withYear((Integer) source.getSelectedItem());
                yearMonthLabel.setText(currentDate.format(formatter));
                setCalValues();
            }
        });
        monthList = new JComboBox<>(months);
        monthList.setSelectedIndex(currentDate.getMonthValue() - 1);
        monthList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                currentDate = currentDate.withMonth((Integer) source.getSelectedIndex() + 1);
                yearMonthLabel.setText(currentDate.format(formatter));
                setCalValues();
            }
        });

        dropDownListPanel.add(yearList);
        dropDownListPanel.add(monthList);

        yearMonthLabel = new JLabel(currentDate.format(formatter), SwingConstants.CENTER);
        prevMonthBtn = new JButton(" <<");
        nextMonthBtn = new JButton(">>");
        prevMonthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentDate.minusMonths(1).getYear() < firstYear) {
                    return;
                }
                currentDate = currentDate.minusMonths(1);
                yearMonthLabel.setText(currentDate.format(formatter));
                setCalValues();
            }
        });
        nextMonthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentDate.plusMonths(1).getYear() > lastYear) {
                    return;
                }
                currentDate = currentDate.plusMonths(1);
                yearMonthLabel.setText(currentDate.format(formatter));
                setCalValues();
            }
        });

        dayPanel = new JPanel(new GridLayout(1, 7));
        dayLabels = new JLabel[7];
        for (int i = 0; i < daysOfWeek.length; i++) {
            dayLabels[i] = new JLabel(daysOfWeek[i], SwingConstants.CENTER);
            dayPanel.add(dayLabels[i]);
        }

        topPanel.add(dropDownListPanel, BorderLayout.NORTH);
        topPanel.add(prevMonthBtn, BorderLayout.LINE_START);
        topPanel.add(yearMonthLabel, BorderLayout.CENTER);
        topPanel.add(nextMonthBtn, BorderLayout.LINE_END);
        topPanel.add(dayPanel, BorderLayout.SOUTH);

        // calendar panel components
        calBtns = new JButton[CALROWS][CALCOLS];
        for (int i = 0; i < CALROWS; i++) {
            for (int j = 0; j < CALCOLS; j++) {
                final int currentRow = i;
                final int currentCol = j;

                calBtns[i][j] = new JButton();
                calBtns[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = calBtns[currentRow][currentCol];
                        selectedDate = currentDate.withDayOfMonth(Integer.parseInt(clickedButton.getText()));
                        selectedDateLabel.setText(
                                "Selected Date: " + selectedDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
                    }
                });
                calendarPanel.add(calBtns[i][j]);
            }
        }
        setCalValues();

        // bottom panel components
        selectedDateLabel = new JLabel("Selected Date: N/A");
        oKBtn = new JButton("OK");
        oKBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ON_CLOSE.run();
            }
        });
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDate = null;
                dispose();
                ON_CLOSE.run();
            }
        });
        bottomPanel.add(selectedDateLabel);
        bottomPanel.add(oKBtn);
        bottomPanel.add(cancelBtn);

        add(topPanel, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(500, 350));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                selectedDate = null;
                dispose();
                ON_CLOSE.run();
            }
        });
    }

    private void setCalValues() {
        firstDayOfWeek = currentDate.withDayOfMonth(1).getDayOfWeek().getValue();
        daysInMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonthValue()).lengthOfMonth();

        YearMonth prevYearMonth = YearMonth.of(currentDate.minusMonths(1).getYear(),
                currentDate.minusMonths(1).getMonthValue());
        int daysInPrevMonth = prevYearMonth.lengthOfMonth();

        int d = 1, nd = 1;
        for (int i = 0; i < CALROWS; i++) {
            for (int j = 0; j < CALCOLS; j++) {
                if (firstDayOfWeek != 7 && i * 7 + j < firstDayOfWeek) {
                    calBtns[i][j].setText("" + (daysInPrevMonth - firstDayOfWeek + j + 1));
                    calBtns[i][j].setEnabled(false);
                } else if (d > daysInMonth) {
                    calBtns[i][j].setText("" + nd);
                    calBtns[i][j].setEnabled(false);
                    nd++;
                } else {
                    calBtns[i][j].setEnabled(true);
                    calBtns[i][j].setText("" + ("" + d));
                    d++;
                }
            }
        }
    }

    public static void main(String[] args) {

    }

    private static JPanel topPanel;
    private static JPanel calendarPanel;
    private static JPanel bottomPanel;
    private static JComboBox<Integer> yearList;
    private static JComboBox<String> monthList;
    private static JPanel dropDownListPanel;
    private static JLabel yearMonthLabel;
    private static JButton prevMonthBtn;
    private static JButton nextMonthBtn;
    private static JPanel dayPanel;
    private static JLabel[] dayLabels;
    private static JButton[][] calBtns;
    private static JLabel selectedDateLabel;
    private static JButton oKBtn;
    private static JButton cancelBtn;
}
