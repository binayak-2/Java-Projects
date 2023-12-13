/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import java.awt.event.KeyEvent;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author binayak
 */
public class internalSubjects extends javax.swing.JInternalFrame {

    /**
     * Creates new form internalClasses
     */
    public internalSubjects() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        table_update();
        table_update1();
        loadFaculty();
        loadClass();
        loadSection();
        loadTeacher();
        addsubject.setEnabled(true);
        updatesubject.setEnabled(false);
        deletesubject.setEnabled(false);
        addfaculty.setEnabled(true);
        updatefaculty.setEnabled(false);
        deletefaculty.setEnabled(false);
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    void clear(){
        
        name.setText("");
        name1.setText("");
        faculty.setSelectedIndex(0);
        grade.setSelectedIndex(0);
        section.setSelectedIndex(0);
        teacher.setSelectedIndex(0);
        credithrs.setText("");
        fm.setText("");
        pm.setText("");
        publication.setText("");
        price.setText("");
        addsubject.setEnabled(true);
        updatesubject.setEnabled(false);
        deletesubject.setEnabled(false);
        addfaculty.setEnabled(true);
        updatefaculty.setEnabled(false);
        deletefaculty.setEnabled(false);
       
    }
    
    void table_update(){
         int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
            pst = con.prepareStatement("SELECT * FROM Subjects");
            rs = pst.executeQuery();

            com.mysql.jdbc.ResultSetMetaData RSMD = (com.mysql.jdbc.ResultSetMetaData) rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) table.getModel();
            DFT.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("subname"));
                    v2.add(rs.getString("faculty"));
                    v2.add(rs.getString("class"));
                    v2.add(rs.getString("section"));
                    v2.add(rs.getString("subteacher"));
                    v2.add(rs.getString("credithrs"));
                    v2.add(rs.getString("fm"));
                    v2.add(rs.getString("pm"));
                    v2.add(rs.getString("publication"));
                    v2.add(rs.getString("price"));
                }

                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }
    
     private void table_update1() {
        int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
            pst = con.prepareStatement("SELECT * FROM Faculty");
            rs = pst.executeQuery();

            com.mysql.jdbc.ResultSetMetaData RSMD = (com.mysql.jdbc.ResultSetMetaData) rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) table1.getModel();
            DFT.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("sn"));
                    v2.add(rs.getString("name"));
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
             teacher.removeAllItems();
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
             teacher.removeAllItems();
             while(rs.next()){
                 section.addItem(rs.getString("section"));  
             }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(internalClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        
    }
    void loadTeacher(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
             pst=con.prepareStatement("select distinct name from Staffs where role = 'Teacher'");
             rs=pst.executeQuery();
             teacher.removeAllItems();
             while(rs.next()){
                 teacher.addItem(rs.getString("name"));  
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

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        faculty = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        teacher = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        addsubject = new javax.swing.JButton();
        updatesubject = new javax.swing.JButton();
        deletesubject = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        credithrs = new javax.swing.JTextField();
        fm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pm = new javax.swing.JTextField();
        publication = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        grade = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        section = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        clearsubject = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        clearfaculty = new javax.swing.JButton();
        deletefaculty = new javax.swing.JButton();
        updatefaculty = new javax.swing.JButton();
        addfaculty = new javax.swing.JButton();
        name1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setBorder(null);

        jTabbedPane1.setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Subject Name");

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setToolTipText("");
        name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Faculty");

        faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        faculty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        faculty.setPreferredSize(new java.awt.Dimension(99, 40));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Class");

        teacher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select..." }));
        teacher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        teacher.setPreferredSize(new java.awt.Dimension(99, 40));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Subject Teacher");

        addsubject.setBackground(new java.awt.Color(254, 254, 254));
        addsubject.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        addsubject.setForeground(new java.awt.Color(1, 1, 1));
        addsubject.setText("Add");
        addsubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        addsubject.setBorderPainted(false);
        addsubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsubjectActionPerformed(evt);
            }
        });

        updatesubject.setBackground(new java.awt.Color(254, 254, 254));
        updatesubject.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        updatesubject.setForeground(new java.awt.Color(1, 1, 1));
        updatesubject.setText("Update");
        updatesubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        updatesubject.setBorderPainted(false);
        updatesubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatesubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesubjectActionPerformed(evt);
            }
        });

        deletesubject.setBackground(new java.awt.Color(254, 254, 254));
        deletesubject.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        deletesubject.setForeground(new java.awt.Color(1, 1, 1));
        deletesubject.setText("Delete");
        deletesubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        deletesubject.setBorderPainted(false);
        deletesubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletesubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesubjectActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Credit Hours");

        credithrs.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        credithrs.setToolTipText("");
        credithrs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        fm.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        fm.setToolTipText("");
        fm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("Final Full Marks");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Final Pass Marks");

        pm.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        pm.setToolTipText("");
        pm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        publication.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        publication.setToolTipText("");
        publication.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Publication");

        price.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        price.setToolTipText("");
        price.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 50, 89), 1, true));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Price");

        grade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        grade.setPreferredSize(new java.awt.Dimension(99, 40));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel12.setText("Section");

        section.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        section.setPreferredSize(new java.awt.Dimension(99, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Faculty", "Class", "Section", "Subject Teacher", "Credit Hours", "FM", "PM", "Publication", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false
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

        clearsubject.setBackground(new java.awt.Color(254, 254, 254));
        clearsubject.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        clearsubject.setForeground(new java.awt.Color(1, 1, 1));
        clearsubject.setText("Clear");
        clearsubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        clearsubject.setBorderPainted(false);
        clearsubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearsubjectActionPerformed(evt);
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
                    .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updatesubject, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deletesubject, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pm)
                            .addComponent(fm)
                            .addComponent(credithrs)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(150, 150, 150)))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addGap(150, 150, 150))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(23, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(publication, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
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
                                    .addComponent(credithrs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(publication, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46))
                            .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(section, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatesubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deletesubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Subjects", jPanel1);

        table1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFocusable(false);
        table1.setIntercellSpacing(new java.awt.Dimension(0, 1));
        table1.setRowHeight(25);
        table1.setShowHorizontalLines(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        clearfaculty.setBackground(new java.awt.Color(254, 254, 254));
        clearfaculty.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        clearfaculty.setText("Clear");
        clearfaculty.setBorderPainted(false);
        clearfaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearfacultyActionPerformed(evt);
            }
        });

        deletefaculty.setBackground(new java.awt.Color(254, 254, 254));
        deletefaculty.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        deletefaculty.setText("Delete");
        deletefaculty.setBorderPainted(false);
        deletefaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletefacultyActionPerformed(evt);
            }
        });

        updatefaculty.setBackground(new java.awt.Color(254, 254, 254));
        updatefaculty.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        updatefaculty.setText("Update");
        updatefaculty.setBorderPainted(false);
        updatefaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatefacultyActionPerformed(evt);
            }
        });

        addfaculty.setBackground(new java.awt.Color(254, 254, 254));
        addfaculty.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        addfaculty.setText("Add");
        addfaculty.setBorderPainted(false);
        addfaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addfacultyActionPerformed(evt);
            }
        });

        name1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));
        name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name1ActionPerformed(evt);
            }
        });
        name1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                name1KeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel13.setText("Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addfaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatefaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearfaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletefaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addfaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(updatefaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(deletefaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(clearfaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                .addGap(185, 185, 185))
        );

        jTabbedPane1.addTab("Faculty", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsubjectActionPerformed

        String sname    = name.getText();
        String sfaculty = faculty.getSelectedItem().toString();
        String sclass   = grade.getSelectedItem().toString();
        String ssect    = section.getSelectedItem().toString();
        String steach   = teacher.getSelectedItem().toString();
        String scredit  = credithrs.getText();
        String sfm      = fm.getText();
        String spm      = pm.getText();
        String spub     = publication.getText();
        String sprice   = price.getText();

        if(sname.trim().isEmpty()|| scredit.trim().isEmpty()|| sfm.trim().isEmpty()|| spm.trim().isEmpty()||spub.trim().isEmpty()|| sprice.trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Details cannot be added. One or more input fields are empty!", "Failed", JOptionPane.ERROR_MESSAGE);

        }else{

            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("insert into Subjects (subname,faculty,class,section,subteacher,credithrs,fm,pm,publication,price)values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, sname);
                pst.setString(2, sfaculty);
                pst.setString(3, sclass);
                pst.setString(4, ssect);
                pst.setString(5, steach);
                pst.setString(6, scredit);
                pst.setString(7, sfm);
                pst.setString(8, spm);
                pst.setString(9, spub);
                pst.setString(10, sprice);
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Added Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                addsubject.setEnabled(true);
                updatesubject.setEnabled(false);
                deletesubject.setEnabled(false);
            
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                

        }

    }//GEN-LAST:event_addsubjectActionPerformed

    private void updatesubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesubjectActionPerformed

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        String sname    = name.getText();
        String sfaculty = faculty.getSelectedItem().toString();
        String sclass   = grade.getSelectedItem().toString();
        String ssect    = section.getSelectedItem().toString();
        String steach   = teacher.getSelectedItem().toString();
        String scredit  = credithrs.getText();
        String sfm      = fm.getText();
        String spm      = pm.getText();
        String spub     = publication.getText();
        String sprice   = price.getText();

       if(sname.trim().isEmpty()|| scredit.trim().isEmpty()|| sfm.trim().isEmpty()|| spm.trim().isEmpty()||spub.trim().isEmpty()|| sprice.trim().isEmpty()){

            JOptionPane.showMessageDialog(null, "Details cannot be updated. One or more input fields are empty!", "Failed", JOptionPane.ERROR_MESSAGE);

        }else{
           
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("update Subjects set subname=?,faculty=?,class=?,section=?,subteacher=?,credithrs=?,fm=?,pm=?,publication=?,price=? where id=?");
               pst.setString(1, sname);
                pst.setString(2, sfaculty);
                pst.setString(3, sclass);
                pst.setString(4, ssect);
                pst.setString(5, steach);
                pst.setString(6, scredit);
                pst.setString(7, sfm);
                pst.setString(8, spm);
                pst.setString(9, spub);
                pst.setString(10, sprice);
                pst.setInt(11, id);
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Updated Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                addsubject.setEnabled(true);
                updatesubject.setEnabled(false);
                deletesubject.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
            

        }

    }//GEN-LAST:event_updatesubjectActionPerformed

    private void deletesubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesubjectActionPerformed

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedIndex = table.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){

            

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("delete from Subjects where id=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                table_update();
                JOptionPane.showMessageDialog(null,"Deleted Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                clear();
                addsubject.setEnabled(true);
                updatesubject.setEnabled(false);
                deletesubject.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
               
        }
           

    }//GEN-LAST:event_deletesubjectActionPerformed

    private void clearsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearsubjectActionPerformed
        
        clear();
        
    }//GEN-LAST:event_clearsubjectActionPerformed

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
                teacher.setSelectedItem(model.getValueAt(selectedIndex, 5).toString());
                credithrs.setText(model.getValueAt(selectedIndex, 6).toString());
                fm.setText(model.getValueAt(selectedIndex, 7).toString());
                pm.setText(model.getValueAt(selectedIndex, 8).toString());
                publication.setText(model.getValueAt(selectedIndex, 9).toString());
                price.setText(model.getValueAt(selectedIndex, 10).toString());
                addsubject.setEnabled(false);
                updatesubject.setEnabled(true);
                deletesubject.setEnabled(true);
        
    }//GEN-LAST:event_tableMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        name1.setText(model.getValueAt(selectedIndex, 1).toString());

        addfaculty.setEnabled(false);
        updatefaculty.setEnabled(true);
        deletefaculty.setEnabled(true);

    }//GEN-LAST:event_table1MouseClicked

    private void clearfacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearfacultyActionPerformed

    clear();
    
    }//GEN-LAST:event_clearfacultyActionPerformed

    private void deletefacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletefacultyActionPerformed

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the record?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("delete from Faculty where sn=? ");
                pst.setInt(1, id);
                pst.executeUpdate();
                table_update1();
                JOptionPane.showMessageDialog(this, "Record Deleted");

                name1.setText("");
                addfaculty.setEnabled(true);
        updatefaculty.setEnabled(false);
        deletefaculty.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
            
        }

    }//GEN-LAST:event_deletefacultyActionPerformed

    private void updatefacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatefacultyActionPerformed

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        String fname = name1.getText();
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
            pst = con.prepareStatement("update Faculty set name= ? where sn=? ");
            pst.setString(1, fname);
            pst.setInt(2, id);
            pst.executeUpdate();
           table_update1();
            name1.setText("");
            JOptionPane.showMessageDialog(this, "Record Updated");
            addfaculty.setEnabled(true);
        updatefaculty.setEnabled(false);
        deletefaculty.setEnabled(false);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
           
       

    }//GEN-LAST:event_updatefacultyActionPerformed

    private void addfacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addfacultyActionPerformed

        if(name1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Input fields cannot be empty.", "Warning", JOptionPane.ERROR_MESSAGE);
        }else{
            String fname = name1.getText();
           
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                pst = con.prepareStatement("insert into Faculty (name)values(?)");
                pst.setString(1, fname);
                pst.executeUpdate();
                table_update1();
                JOptionPane.showMessageDialog(null,"Added Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                name1.setText("");
                addfaculty.setEnabled(true);
        updatefaculty.setEnabled(false);
        deletefaculty.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
            
        }

    }//GEN-LAST:event_addfacultyActionPerformed

    private void name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name1ActionPerformed

    private void name1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name1KeyPressed

        if(evt.getKeyCode()== KeyEvent.VK_ENTER){

            if(name1.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Input fields cannot be empty.", "Warning", JOptionPane.ERROR_MESSAGE);
            }else{
                String fname = name1.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/schoolManagementSystem", "root", "");
                    pst = con.prepareStatement("insert into Faculty (name)values(?)");
                    pst.setString(1, fname);
                    pst.executeUpdate();
                    table_update1();
                    JOptionPane.showMessageDialog(null,"Added Successfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    name1.setText("");
                } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(internalSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            }
        }

    }//GEN-LAST:event_name1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addfaculty;
    private javax.swing.JButton addsubject;
    private javax.swing.JButton clearfaculty;
    private javax.swing.JButton clearsubject;
    private javax.swing.JTextField credithrs;
    private javax.swing.JButton deletefaculty;
    private javax.swing.JButton deletesubject;
    private javax.swing.JComboBox<String> faculty;
    private javax.swing.JTextField fm;
    private javax.swing.JComboBox<String> grade;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField pm;
    private javax.swing.JTextField price;
    private javax.swing.JTextField publication;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> section;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JComboBox<String> teacher;
    private javax.swing.JButton updatefaculty;
    private javax.swing.JButton updatesubject;
    // End of variables declaration//GEN-END:variables
}
