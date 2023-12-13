/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author binayak
 */
public class internalStudents extends javax.swing.JInternalFrame {

    /**
     * Creates new form internalClasses
     */
    public internalStudents() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        table_update();
        loadFaculty();
        loadClass();
        loadSection();
        add.setEnabled(true);
        update.setEnabled(false);
        delete.setEnabled(false);
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
        void clear(){
        
        name.setText("");
        faculty.setSelectedIndex(0);
        grade.setSelectedIndex(0);
        section.setSelectedIndex(0);
        
        address.setText("");
        father.setText("");
        mother.setText("");
        contact.setText("");
        dob.setText("");
        add.setEnabled(true);
        update.setEnabled(false);
        delete.setEnabled(false);
        
       
    }
        
        void table_update(){
         int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
            pst = con.prepareStatement("SELECT * FROM Students");
            rs = pst.executeQuery();

            com.mysql.jdbc.ResultSetMetaData RSMD = (com.mysql.jdbc.ResultSetMetaData) rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) table.getModel();
            DFT.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("class"));
                    v2.add(rs.getString("section"));
                    v2.add(rs.getString("faculty"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("dob"));
                    v2.add(rs.getString("father"));
                    v2.add(rs.getString("mother"));
                    v2.add(rs.getString("contact"));
                }

                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }
    
    void loadFaculty(){
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
             pst=con.prepareStatement("select distinct name from Faculty");
             rs=pst.executeQuery();
             faculty.removeAllItems();
             while(rs.next()){
                 faculty.addItem(rs.getString("name"));  
             }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
    }
    
    void loadClass(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
             pst=con.prepareStatement("select distinct name from Classes");
             rs=pst.executeQuery();
             grade.removeAllItems();
             while(rs.next()){
                 grade.addItem(rs.getString("name"));  
             }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    void loadSection(){
        
       try {
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
             pst=con.prepareStatement("select distinct section from Classes ");
             rs=pst.executeQuery();
             section.removeAllItems();
             while(rs.next()){
                 section.addItem(rs.getString("section"));  
             }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        grade = new javax.swing.JComboBox<>();
        faculty = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        father = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mother = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        section = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        delete1 = new javax.swing.JButton();
        search = new javax.swing.JTextField();

        setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Student Full Name");

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setToolTipText("");
        name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Class");

        grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        grade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        grade.setPreferredSize(new java.awt.Dimension(99, 40));

        faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        faculty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        faculty.setPreferredSize(new java.awt.Dimension(99, 40));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Faculty");

        add.setBackground(new java.awt.Color(254, 254, 254));
        add.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(1, 1, 1));
        add.setText("Add");
        add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        add.setBorderPainted(false);
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(254, 254, 254));
        update.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(1, 1, 1));
        update.setText("Update");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        update.setBorderPainted(false);
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(254, 254, 254));
        delete.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(1, 1, 1));
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        delete.setBorderPainted(false);
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Address");

        address.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        address.setToolTipText("");
        address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        father.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        father.setToolTipText("");
        father.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("Father's Name");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Contact");

        contact.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        contact.setToolTipText("");
        contact.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        dob.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        dob.setToolTipText("");
        dob.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Date Of Birth");

        mother.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        mother.setToolTipText("");
        mother.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Mother's Name");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel12.setText("Section");

        section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        section.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        section.setPreferredSize(new java.awt.Dimension(99, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Faculty", "Class", "Section", "Address", "DOB", "Father", "Mother", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        delete1.setBackground(new java.awt.Color(254, 254, 254));
        delete1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        delete1.setForeground(new java.awt.Color(1, 1, 1));
        delete1.setText("Clear");
        delete1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        delete1.setBorderPainted(false);
        delete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        search.setText("Search...");
        search.setToolTipText("");
        search.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contact)
                            .addComponent(father)
                            .addComponent(address)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(150, 150, 150)))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addContainerGap(89, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(mother, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dob, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                                    .addComponent(jLabel10))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(father, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mother, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        String sname    = name.getText();
        String sclass = grade.getSelectedItem().toString();
        String ssect    = section.getSelectedItem().toString();
        String sfaculty   = faculty.getSelectedItem().toString();
        String saddress  = address.getText();
        String sfather      = father.getText();
        String scontact      = contact.getText();
        String sdob     = dob.getText();
        String smother   = mother.getText();

        if(sname.trim().isEmpty()|| saddress.trim().isEmpty()|| sfather.trim().isEmpty()|| scontact.trim().isEmpty()||sdob.trim().isEmpty()|| smother.trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Details cannot be added. One or more input fields are empty!", "Failed", JOptionPane.ERROR_MESSAGE);

        }else{

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("insert into Students (name,class,section,faculty,address,dob,father,mother,contact,username,password)values(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, sname);
                pst.setString(2, sclass);
                pst.setString(3, ssect);
                pst.setString(4, sfaculty);
                pst.setString(5, saddress);
                pst.setString(6, sdob);
                pst.setString(7, sfather);
                pst.setString(8, smother);
                pst.setString(9, scontact);
                pst.setString(10, "no");
                pst.setString(11, "no");
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Added Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                add.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);

            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        String sname    = name.getText();
        String sclass = grade.getSelectedItem().toString();
        String ssect    = section.getSelectedItem().toString();
        String sfaculty   = faculty.getSelectedItem().toString();
        String saddress  = address.getText();
        String sfather      = father.getText();
        String scontact      = contact.getText();
        String sdob     = dob.getText();
        String smother   = mother.getText();

if(sname.trim().isEmpty()|| saddress.trim().isEmpty()|| sfather.trim().isEmpty()|| scontact.trim().isEmpty()||sdob.trim().isEmpty()|| smother.trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Details cannot be updated. One or more input fields are empty!", "Failed", JOptionPane.ERROR_MESSAGE);

        }else{

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("update Students set name=?,class=?,section=?,faculty=?,address=?,dob=?,father=?,mother=?,contact where id=?");
                pst.setString(1, sname);
                pst.setString(2, sclass);
                pst.setString(3, ssect);
                pst.setString(4, sfaculty);
                pst.setString(5, saddress);
                pst.setString(6, sdob);
                pst.setString(7, sfather);
                pst.setString(8, smother);
                pst.setString(9, scontact);
              
                pst.setInt(11, id);
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Updated Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                add.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("delete from Students where id=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Deleted Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                add.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_deleteActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

        search.setText("");

    }//GEN-LAST:event_searchKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        name.setText(model.getValueAt(selectedIndex, 1).toString());
        faculty.setSelectedItem(model.getValueAt(selectedIndex, 2).toString());
       
        grade.setSelectedItem(model.getValueAt(selectedIndex, 3).toString());
        section.setSelectedItem(model.getValueAt(selectedIndex, 4).toString());
        address.setText(model.getValueAt(selectedIndex, 5).toString());
        dob.setText(model.getValueAt(selectedIndex, 6).toString());
        father.setText(model.getValueAt(selectedIndex, 7).toString());
        mother.setText(model.getValueAt(selectedIndex, 8).toString());
        contact.setText(model.getValueAt(selectedIndex, 9).toString());
        add.setEnabled(false);
        update.setEnabled(true);
        delete.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed

        clear();
        
    }//GEN-LAST:event_delete1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField address;
    private javax.swing.JTextField contact;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JTextField dob;
    private javax.swing.JComboBox<String> faculty;
    private javax.swing.JTextField father;
    private javax.swing.JComboBox<String> grade;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mother;
    private javax.swing.JTextField name;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
