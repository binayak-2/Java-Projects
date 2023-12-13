/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cricnep;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binayak
 */
public class svenue extends javax.swing.JFrame {

    /**
     * Creates new form svenue
     */
    public svenue() {
        initComponents();
       
    }
    String leagueN;
    svenue(String name) {
        initComponents();
        this.leagueN=name;
       
    }

   Connection con;
   PreparedStatement pst;
   ResultSet rs;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        leagueName = new javax.swing.JLabel();
        vName = new javax.swing.JTextField();
        leagueName1 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        leagueName2 = new javax.swing.JLabel();
        vcountry = new javax.swing.JTextField();
        selectCountry = new javax.swing.JComboBox<>();
        leagueName3 = new javax.swing.JLabel();
        leagueName4 = new javax.swing.JLabel();
        sVenue = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        select = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        leagueName5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        leagueName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName.setText("Name");

        vName.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        leagueName1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName1.setText("Location");

        location.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        leagueName2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName2.setText("Venue");

        vcountry.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        selectCountry.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        leagueName3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName3.setText("Country");

        leagueName4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName4.setText("Venue");

        sVenue.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        save.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        select.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        leagueName5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        leagueName5.setText("Country");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leagueName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(vName, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(leagueName)
                        .addComponent(leagueName1)
                        .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leagueName4)
                    .addComponent(sVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(leagueName2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(422, Short.MAX_VALUE)
                    .addComponent(leagueName5)
                    .addGap(319, 319, 319)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(leagueName2)
                .addGap(29, 29, 29)
                .addComponent(leagueName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leagueName1)
                            .addComponent(leagueName4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(leagueName3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(leagueName5)
                    .addContainerGap(349, Short.MAX_VALUE)))
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

        String vname=vName.getText();
        String vlocation=location.getText();
        String country=vcountry.getText();

        if(vname.trim().isEmpty()||vlocation.trim().isEmpty()||country.trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Input Fields cannot be empty!", "Error", JOptionPane.OK_OPTION);
        }
        else{

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/cricket_score", "root", "");
                pst = con.prepareStatement("insert into venue (name,location,country,league)values(?,?,?,?)");
                pst.setString(1, vname);
                pst.setString(2, vlocation);
                pst.setString(3, country);
                pst.setString(4, leagueN);

                pst.executeUpdate();
               
                vName.setText("");
                location.setText("");
                vcountry.setText("");
                

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(createSeries.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_saveActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
  
    }//GEN-LAST:event_selectActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(svenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(svenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(svenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(svenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new svenue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel leagueName;
    private javax.swing.JLabel leagueName1;
    private javax.swing.JLabel leagueName2;
    private javax.swing.JLabel leagueName3;
    private javax.swing.JLabel leagueName4;
    private javax.swing.JLabel leagueName5;
    private javax.swing.JTextField location;
    private javax.swing.JComboBox<String> sVenue;
    private javax.swing.JButton save;
    private javax.swing.JButton select;
    private javax.swing.JComboBox<String> selectCountry;
    private javax.swing.JTextField vName;
    private javax.swing.JTextField vcountry;
    // End of variables declaration//GEN-END:variables
}
