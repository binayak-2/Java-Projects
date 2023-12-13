/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cricnep;

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author binayak
 */
public class manageTeam extends javax.swing.JFrame {

    /**
     * Creates new form manageTeam
     */
    public manageTeam() {
        initComponents();
        showteam();
        table_update();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    String nameofteam;
    
    manageTeam(String team) {
        this.nameofteam=team;
        initComponents();
        showteam();
        table_update();
    }

    void showteam(){
        team.setText(nameofteam);
    }
    
     private void table_update() {
        int CC;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cricket_score", "root", "");
                pst = con.prepareStatement("SELECT * FROM playersInfo where team=?");
                pst.setString(1,nameofteam);
                rs = pst.executeQuery();
                ResultSetMetaData RSMD = (ResultSetMetaData) rs.getMetaData();
                CC = RSMD.getColumnCount();
                DefaultTableModel DFT = (DefaultTableModel) table2.getModel();
                DFT.setRowCount(0);
                while (rs.next()) {
                Vector v2 = new Vector();

                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("role"));
                    v2.add(rs.getString("location"));   
                    v2.add(rs.getString("wk"));
                    v2.add(rs.getString("playingXI"));
                    v2.add(rs.getString("captain")); 
                     v2.add(rs.getString("pid")); 
                }

                DFT.addRow(v2);
            }
          
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        leagueName = new javax.swing.JLabel();
        playername = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        team = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        leagueName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName.setText("Player Name");

        playername.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jRadioButton1.setText("Overseas");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jRadioButton2.setText("National");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jCheckBox1.setText("Playing XI");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jCheckBox2.setText("Wicketkeeper");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jRadioButton5.setText("Batsmen");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jRadioButton6.setText("Bowler");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jRadioButton7.setText("All Rounder");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        table2.setBorder(null);
        table2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Role", "Location", "WK", "Playing XI", "Captain", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setGridColor(new java.awt.Color(138, 112, 132));
        table2.setRowHeight(20);
        table2.setRowMargin(2);
        table2.setShowHorizontalLines(false);
        table2.setShowVerticalLines(false);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        team.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        team.setText("Team");

        jCheckBox3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jCheckBox3.setText("Captain");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leagueName)
                                        .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(team)
                        .addGap(289, 289, 289))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leagueName)
                    .addComponent(team))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox3)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        String pname=playername.getText();

        if(pname.trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Player name cannot be empty!", "Error", JOptionPane.OK_OPTION);
        }
        else{

            try {

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/cricket_score", "root", "");
                    pst = con.prepareStatement("insert into playersInfo (name,role,location,captain,wk,playingXI,team)values(?,?,?,?,?,?,?)");
                    pst.setString(1, pname);
                    pst.setString(2, role);
                    pst.setString(3, location);
                    pst.setString(4, captain);
                    pst.setString(5, wk);
                    pst.setString(6, pxi);
                    pst.setString(7, nameofteam);
                    pst.executeUpdate();
                    table_update();
                    playername.setText("");
                    update.setEnabled(false);
                    delete.setEnabled(false);
                

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(createSeries.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 6).toString());
        String pname=playername.getText();

        if(pname.trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Player name cannot be empty!", "Error", JOptionPane.OK_OPTION);
        }
        else{

            try {

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/cricket_score", "root", "");
                    pst = con.prepareStatement("update playersInfo set name=?,role=?,location=?,captain=?,wk=?,playingXI=? where pid=?");
                    pst.setString(1, pname);
                    pst.setString(2, role);
                    pst.setString(3, location);
                    pst.setString(4, captain);
                    pst.setString(5, wk);
                    pst.setString(6, pxi);
                    pst.setInt(7, id);
                    pst.executeUpdate();
                    table_update();
                    playername.setText("");
                    update.setEnabled(false);
                    delete.setEnabled(false);
                

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(createSeries.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 6).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            
             try {
                 
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cricket_score", "root", "");
                pst = con.prepareStatement("delete from playersInfo where pid=?");
                pst.setInt(1, id);
                pst.executeUpdate();
                table_update();
                save.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);
                
                 
             } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex);
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
             }
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        
        playername.setText("");
        
    }//GEN-LAST:event_resetActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked

        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        int selectedIndex = table2.getSelectedRow();

        playername.setText(model.getValueAt(selectedIndex, 0).toString());
        
        update.setEnabled(true);
        delete.setEnabled(true);
        save.setEnabled(false);

    }//GEN-LAST:event_table2MouseClicked

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
   
        role="Batsmen";  
        
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
    
        role="Bowler"; 
        
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
       
        role="All Rounder"; 
        
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        
        location="Overseas";
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       
        location="National";
        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
       
       
            captain="Yes";
        
        
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
       

            wk="Yes";
       
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       
      
            pxi="Yes";
       
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(manageTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageTeam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leagueName;
    private javax.swing.JTextField playername;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTable table2;
    private javax.swing.JLabel team;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

public String role;
public String location;
public String captain;
public String wk;
public String pxi;



}
