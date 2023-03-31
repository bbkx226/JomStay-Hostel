package DesignUI;

import Models.Room;
import Utils.PopUpWindow;
import Utils.RoomHandling;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HostelAD extends javax.swing.JFrame {
    private final ArrayList<Room> rooms = new RoomHandling().totalRooms;
    private int record = 0;
    private boolean isAppend = false; // True for append, False for Edit
    /**
     * Creates new form Hostel
     */
    public HostelAD() {
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

        searchField = new javax.swing.JTextField();
        yesOrNo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        hostelIcon = new javax.swing.JLabel();
        applicationIcon = new javax.swing.JLabel();
        signoutIcon = new javax.swing.JLabel();
        students = new javax.swing.JLabel();
        reportsIcon = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        roomID = new javax.swing.JLabel();
        firstQuery = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        roomStatus = new javax.swing.JComboBox<>();
        nextQuery = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        yesRadioButton = new javax.swing.JRadioButton();
        noRadioButton = new javax.swing.JRadioButton();
        lastQuery = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        roomPrice = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        previousQuery = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        roomPax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();

        searchField.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        hostelIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        hostelIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hostelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hostel.png"))); // NOI18N
        hostelIcon.setText("Rooms");
        hostelIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        applicationIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        applicationIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        applicationIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/application.png"))); // NOI18N
        applicationIcon.setText("Application");
        applicationIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        applicationIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationIconMouseClicked(evt);
            }
        });

        signoutIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signoutIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        signoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/log-out.png"))); // NOI18N
        signoutIcon.setText("Sign out");
        signoutIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signoutIconMouseClicked(evt);
            }
        });

        students.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        students.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        students.setText("Students");
        students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
        });

        reportsIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        reportsIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seo-report.png"))); // NOI18N
        reportsIcon.setText("Reports");
        reportsIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsIconMouseClicked(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/x.png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(hostelIcon)
                .addGap(121, 121, 121)
                .addComponent(applicationIcon)
                .addGap(123, 123, 123)
                .addComponent(students)
                .addGap(105, 105, 105)
                .addComponent(reportsIcon)
                .addGap(130, 130, 130)
                .addComponent(signoutIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(signoutIcon)
                            .addComponent(reportsIcon)
                            .addComponent(students)
                            .addComponent(applicationIcon)
                            .addComponent(hostelIcon)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitButton)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Room Management");

        searchBox.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(153, 153, 255));
        searchButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel2.setText("ID:");

        roomID.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        firstQuery.setBackground(new java.awt.Color(153, 153, 255));
        firstQuery.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        firstQuery.setForeground(new java.awt.Color(240, 240, 240));
        firstQuery.setText("|<");
        firstQuery.setToolTipText("");
        firstQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        firstQuery.setMaximumSize(new java.awt.Dimension(22, 22));
        firstQuery.setMinimumSize(new java.awt.Dimension(22, 22));
        firstQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstQueryActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel8.setText("Status:");

        roomStatus.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        roomStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Occupied" }));

        nextQuery.setBackground(new java.awt.Color(153, 153, 255));
        nextQuery.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        nextQuery.setForeground(new java.awt.Color(240, 240, 240));
        nextQuery.setText(">");
        nextQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQueryActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel13.setText("Servicing:");

        yesRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        yesOrNo.add(yesRadioButton);
        yesRadioButton.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        yesRadioButton.setText("Yes");

        noRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        yesOrNo.add(noRadioButton);
        noRadioButton.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        noRadioButton.setText("No");

        lastQuery.setBackground(new java.awt.Color(153, 153, 255));
        lastQuery.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lastQuery.setForeground(new java.awt.Color(240, 240, 240));
        lastQuery.setText(">|");
        lastQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lastQuery.setMaximumSize(new java.awt.Dimension(22, 22));
        lastQuery.setMinimumSize(new java.awt.Dimension(22, 22));
        lastQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastQueryActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel14.setText("Pax:");

        addButton.setBackground(new java.awt.Color(153, 153, 255));
        addButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        previousQuery.setBackground(new java.awt.Color(153, 153, 255));
        previousQuery.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        previousQuery.setForeground(new java.awt.Color(240, 240, 240));
        previousQuery.setText("<");
        previousQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQueryActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(153, 153, 255));
        removeButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("Remove");
        removeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        doneButton.setBackground(new java.awt.Color(153, 153, 255));
        doneButton.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        doneButton.setForeground(new java.awt.Color(255, 255, 255));
        doneButton.setText("Done");
        doneButton.setToolTipText("");
        doneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel15.setText("Price:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(234, 234, 234)
                            .addComponent(firstQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(previousQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(nextQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lastQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel2)
                                .addComponent(jLabel15))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(yesRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(noRadioButton))
                                    .addComponent(roomStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(roomID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomPax, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(442, 442, 442)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextQuery)
                    .addComponent(previousQuery)
                    .addComponent(firstQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomID)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(roomStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(yesRadioButton)
                    .addComponent(noRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomPax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(roomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        roomTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));
        roomTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Servicing", "Price", "Price/pax"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomTable.getTableHeader().setReorderingAllowed(false);
        roomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
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
        if (dialogResult == JOptionPane.YES_OPTION)
        {
            PopUpWindow.showGoodByeMessage("Thanks for using the system, have a nice day~", "Goodbye~");
            setVisible(false);
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_signoutIconMouseClicked

    private void roomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomTableMouseClicked
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow >= 0)
        {
            String selectedRoomID = String.valueOf(roomTable.getModel().getValueAt(selectedRow, 0));
            for(Room data: rooms)
            {
                if(data.getRoomID().equals(selectedRoomID))
                {
                    showInForm(selectedRow);
                    break;
                }
            }
        }
    }//GEN-LAST:event_roomTableMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchRoom();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void firstQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstQueryActionPerformed
        showInForm(0);
    }//GEN-LAST:event_firstQueryActionPerformed

    private void nextQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQueryActionPerformed
        record++;
        showInForm(record);
    }//GEN-LAST:event_nextQueryActionPerformed

    private void lastQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastQueryActionPerformed
        int total = rooms.size();
        showInForm(total - 1);
    }//GEN-LAST:event_lastQueryActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        isAppend = true;
        String ID = String.format("R%03d", rooms.size()+1);
        roomID.setText(ID);
        roomStatus.setSelectedItem("Available");
        noRadioButton.doClick();
        roomPax.setText("");
        roomPrice.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void previousQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQueryActionPerformed
        record--;
        showInForm(record);
    }//GEN-LAST:event_previousQueryActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        deleteRoom();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        if(isAppend) appendRoom();
        else modifyRoom();
        dispose();
        new HostelAD().start();
        showInForm(0);
    }//GEN-LAST:event_doneButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel tableModel = (DefaultTableModel) roomTable.getModel();
        tableModel.setRowCount(0);
        for (Room room : rooms) {
            tableModel.addRow(new Object[]{room.getRoomID(), room.getStatus(), room.isServicing(), room.getPax(), room.getPricePerPax()});
        }
        showInForm(0);
    }//GEN-LAST:event_formComponentShown

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) searchRoom();
    }//GEN-LAST:event_searchBoxKeyPressed

    private void applicationIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationIconMouseClicked
        dispose();
        new ApplicationAD().start();
    }//GEN-LAST:event_applicationIconMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked
        dispose();
        new RecordAD().start();
    }//GEN-LAST:event_studentsMouseClicked

    private void reportsIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsIconMouseClicked
        dispose();
        new ReportAD().start();
    }//GEN-LAST:event_reportsIconMouseClicked
    
    // This method is used to set the screen to visible
    public void start() {
        new HostelAD().setVisible(true);
    }
    
    // This method is used to show the details of the room selected by the user.
    // It takes in the index of the room selected from the JList.
    private void showInForm(int index) {
        // retrieve the index from the list
        record = getValidIndex(index);
        // get the room object
        Room room = rooms.get(record);
        // set the text fields
        roomID.setText(room.getRoomID());
        roomStatus.setSelectedItem(room.getStatus());
        if (room.isServicing()) yesRadioButton.doClick();
        else noRadioButton.doClick();
        roomPax.setText(String.valueOf(room.getPax()));
        roomPrice.setText(String.valueOf(room.getPricePerPax()));
    }

    // The code below is used to check the index of the room 
    // and to make sure that the index is not out of bounds.
    private int getValidIndex(int index) {
        if (index >= rooms.size()) return 0;
        else if (index < 0) return rooms.size() - 1;
        return index;
    }
    
    // This function modifies the room. It is called when a player wants to modify the room.
    private void modifyRoom() {
        Room roomToModify = rooms.get(record);
        String oldStatus = roomToModify.getStatus();
        boolean oldServicing = roomToModify.isServicing(); 
        int oldPax = roomToModify.getPax(), oldPrice = roomToModify.getPricePerPax();

        String newStatus = (String) roomStatus.getSelectedItem();
        boolean newServicing = yesRadioButton.isSelected(), flag = true;
        flag = checkTextInt(roomPax, flag);
        flag = checkTextInt(roomPrice, flag);

        int newPax = Integer.parseInt(roomPax.getText());
        int newPrice = Integer.parseInt(roomPrice.getText());

        if (flag) {
            boolean statusChanged = !oldStatus.equals(newStatus);
            boolean servicingChanged = oldServicing != newServicing;
            boolean paxChanged = oldPax != newPax;
            boolean priceChanged = oldPrice != newPrice;
            
            if (statusChanged || servicingChanged || paxChanged || priceChanged) {
                roomToModify.setStatus(newStatus);
                roomToModify.setServicing(newServicing);
                roomToModify.setPax(newPax);
                roomToModify.setPricePerPax(newPrice);
                RoomHandling.updateRoomFile(rooms);
                PopUpWindow.showSuccessfulMessage(
                    "Your updates to the room details have been successfully applied", 
                    "Congrats!"
                );
            }
        }
    }

    // This function searches a room number in the room list
    private void searchRoom() {
        String key = searchBox.getText().trim();
        if (key != null && key.length() > 0) key = key.substring(0, 1).toUpperCase() + key.substring(1);
        record = findRoomRecordNumber(key);
        if (record >= 0) showInForm(record);
        else PopUpWindow.showErrorMessage("Your search did not match any records", "Error 404 occurred");
        searchBox.setText("");
    }

    // This function finds the index of the room in the room list
    private int findRoomRecordNumber(String searchKey) {
        for (int i = 0; i < rooms.size(); i++) {
            if (searchKey.equals(rooms.get(i).getRoomID())) return i;
        }
        return -1;
    }
    
    // This function deletes a room
    private void deleteRoom(){
        String roomNo = rooms.get(record).getRoomID();
        RoomHandling.deleteRoomData(rooms, roomNo);
        PopUpWindow.showSuccessfulMessage(
            "The room details have been deleted successfully", 
            "Congrats!"
        );
        dispose();
        new HostelAD().start();
        showInForm(0);
    }
    
    // Appends a room to the end of the room list.
    private void appendRoom(){
        boolean flag = true;
        flag = checkTextInt(roomPax, flag);
        flag = checkTextInt(roomPrice,flag);
        
        if (flag){
            Room roomToAppend = new Room(roomID.getText(), (String) roomStatus.getModel().getSelectedItem(), yesRadioButton.isSelected(), Integer.parseInt(roomPax.getText()), Integer.parseInt(roomPrice.getText()));
            rooms.add(roomToAppend);
            RoomHandling.appendRoomFile(rooms);
            PopUpWindow.showSuccessfulMessage(
                "The room details have been added successfully", 
                "Congrats!"
                );
            isAppend = false;
        }
    }

    // Checks if the user input in the text field is an integer
    private boolean checkTextInt(JTextField text, boolean flag){
        try {
            int value = Integer.parseInt(text.getText());
            if (value <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            flag = false;
            text.setText("");
            PopUpWindow.showFormatErrorMessage(
                "Please ensure you've entered an integer", 
                "Invalid Integer Input"
            );
        }
        return flag;
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
            java.util.logging.Logger.getLogger(HostelAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HostelAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HostelAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HostelAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HostelAD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel applicationIcon;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JButton firstQuery;
    private javax.swing.JLabel hostelIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastQuery;
    private javax.swing.JButton nextQuery;
    private javax.swing.JRadioButton noRadioButton;
    private javax.swing.JButton previousQuery;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel reportsIcon;
    private javax.swing.JLabel roomID;
    private javax.swing.JTextField roomPax;
    private javax.swing.JTextField roomPrice;
    private javax.swing.JComboBox<String> roomStatus;
    private javax.swing.JTable roomTable;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel signoutIcon;
    private javax.swing.JLabel students;
    private javax.swing.ButtonGroup yesOrNo;
    private javax.swing.JRadioButton yesRadioButton;
    // End of variables declaration//GEN-END:variables
}
