/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FrontPage Dreamer
 */
public class reset extends javax.swing.JFrame {

    /**
     * Creates new form reset
     */
    public reset() {
        initComponents();
    }
    String username;
    
    public reset(String uname) {
        this.username = uname;
        initComponents();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        logInBtn = new javax.swing.JButton();
        showpassword = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        warningText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        password.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        password.setToolTipText("Password");
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));

        logInBtn.setBackground(new java.awt.Color(31, 41, 55));
        logInBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        logInBtn.setForeground(new java.awt.Color(255, 255, 255));
        logInBtn.setText("Reset");
        logInBtn.setBorder(null);
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });

        showpassword.setBackground(new java.awt.Color(255, 255, 255));
        showpassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        showpassword.setText("Show Password");
        showpassword.setToolTipText("Show Password");
        showpassword.setBorder(null);
        showpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setText("Reset Password");

        warningText.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        warningText.setForeground(new java.awt.Color(0, 204, 102));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Confirm Password");

        cpassword.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        cpassword.setToolTipText("Password");
        cpassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 228, 232), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(warningText, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(135, 135, 135)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(showpassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warningText, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showpassword)
                .addGap(8, 8, 8)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        
        if (password.getText().trim().isEmpty() || cpassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reset Failed");
        } else {
            try {
                if (password.getText().equals(cpassword.getText())) {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/songs", "root", "");
                    pst = con.prepareStatement("update login set password=? where username=?");
                    pst.setString(1, cpassword.getText());
                    pst.setString(2, username);
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Reset Successfully");
                    login l = new login();
                    this.hide();
                    l.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Login Failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logInBtnActionPerformed

    private void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
        
        if (showpassword.isSelected()) {
            password.setEchoChar((char) 0);
            cpassword.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*');
            cpassword.setEchoChar('*');
            
        }
    }//GEN-LAST:event_showpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cpassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logInBtn;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showpassword;
    private javax.swing.JLabel warningText;
    // End of variables declaration//GEN-END:variables
}
