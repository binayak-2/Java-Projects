/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultpackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author FrontPage Dreamer
 */
public class schoolInfoUpdate extends javax.swing.JFrame {

    /**
     * Creates new form schoolInfoUpdate
     */
    public schoolInfoUpdate() {
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
        jPanel3 = new javax.swing.JPanel();
        schoolName = new javax.swing.JLabel();
        schoolAddress = new javax.swing.JLabel();
        schoolLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        principleName6 = new javax.swing.JLabel();
        principleName7 = new javax.swing.JLabel();
        principleName8 = new javax.swing.JLabel();
        sAddress = new javax.swing.JTextField();
        principleNamePreview2 = new javax.swing.JLabel();
        sName = new javax.swing.JTextField();
        sEstd = new javax.swing.JTextField();
        uploadBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sFilepath = new javax.swing.JTextArea();
        featureBtn = new javax.swing.JButton();
        principleName9 = new javax.swing.JLabel();
        sSlogan = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(33, 9, 78));

        jPanel3.setBackground(new java.awt.Color(33, 9, 78));

        schoolName.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        schoolName.setForeground(new java.awt.Color(255, 255, 255));
        schoolName.setText("Shree Secondary School");

        schoolAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        schoolAddress.setForeground(new java.awt.Color(255, 255, 255));
        schoolAddress.setText("Shivasatakshi 8 Jhiljhile Jhapa");

        schoolLogo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        schoolLogo.setForeground(new java.awt.Color(255, 255, 255));
        schoolLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\FrontPage Dreamer\\Documents\\Icons\\download.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schoolLogo)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schoolName)
                    .addComponent(schoolAddress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schoolLogo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(schoolName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(schoolAddress))))
        );

        jPanel2.setBackground(new java.awt.Color(33, 9, 78));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        principleName6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        principleName6.setForeground(new java.awt.Color(255, 255, 255));
        principleName6.setText("School Name");

        principleName7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        principleName7.setForeground(new java.awt.Color(255, 255, 255));
        principleName7.setText("School Address");

        principleName8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        principleName8.setForeground(new java.awt.Color(255, 255, 255));
        principleName8.setText("Estd. Date");

        sAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        sAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sAddressActionPerformed(evt);
            }
        });

        principleNamePreview2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        principleNamePreview2.setForeground(new java.awt.Color(255, 255, 255));
        principleNamePreview2.setText("Note: Please only select the image having 100 X 100 resolution.");
        principleNamePreview2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        sName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        sName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNameActionPerformed(evt);
            }
        });

        sEstd.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        sEstd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sEstdActionPerformed(evt);
            }
        });

        uploadBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        uploadBtn.setText("Upload Logo");
        uploadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        sFilepath.setColumns(20);
        sFilepath.setRows(5);
        jScrollPane1.setViewportView(sFilepath);

        featureBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        featureBtn.setText("Feature");
        featureBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        featureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureBtnActionPerformed(evt);
            }
        });

        principleName9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        principleName9.setForeground(new java.awt.Color(255, 255, 255));
        principleName9.setText("School Slogan");

        sSlogan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        sSlogan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sSloganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(principleNamePreview2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(principleName6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(principleName7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(principleName8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(principleName9)
                                    .addComponent(uploadBtn))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sEstd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sSlogan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(featureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(principleNamePreview2)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principleName6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principleName7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principleName8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sEstd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(uploadBtn)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principleName9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(featureBtn)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        backBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addGap(41, 41, 41))
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

    private void sAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sAddressActionPerformed

    private void sNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNameActionPerformed

    private void sEstdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sEstdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sEstdActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        schoolLogo.setIcon(new ImageIcon(f.toString()));
        String filename = f.getAbsolutePath();
        sFilepath.setText(filename);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }

            photo = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_uploadBtnActionPerformed

    private void featureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureBtnActionPerformed
        if (sName.getText().trim().isEmpty() || sAddress.getText().trim().isEmpty() || sEstd.getText().trim().isEmpty() || sFilepath.getText().trim().isEmpty() || sSlogan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input fields cannot be empty. All informations are required.", "Message", JOptionPane.OK_OPTION);
        } else {
            String schoolname = sName.getText();
            String schooladdress = sAddress.getText();
            String estd = sEstd.getText();
            String slogan = sSlogan.getText();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/smart_school_management", "root", "");
                pst = con.prepareStatement("update school_info set name= ?,address= ?, estd= ?, logo= ?, slogan= ? where id= 1");
                //pst = con.prepareStatement("insert into school_info (name,address,estd,logo) values(?,?,?,?)");
                pst.setString(1, schoolname);
                pst.setString(2, schooladdress);
                pst.setString(3, estd);
                pst.setBytes(4, photo);
                pst.setString(5, slogan);
                pst.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(schoolInfoUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(schoolInfoUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            schoolName.setText(schoolname);
            schoolAddress.setText(schooladdress);
            sName.setText(" ");
            sAddress.setText(" ");
            sEstd.setText(" ");
            sFilepath.setText(" ");
            sSlogan.setText(" ");

        }
    }//GEN-LAST:event_featureBtnActionPerformed

    private void sSloganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sSloganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sSloganActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        settingsPage sp = new settingsPage();
        this.hide();
        sp.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(schoolInfoUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(schoolInfoUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(schoolInfoUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(schoolInfoUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new schoolInfoUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton featureBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel principleName6;
    private javax.swing.JLabel principleName7;
    private javax.swing.JLabel principleName8;
    private javax.swing.JLabel principleName9;
    private javax.swing.JLabel principleNamePreview2;
    private javax.swing.JTextField sAddress;
    private javax.swing.JTextField sEstd;
    private javax.swing.JTextArea sFilepath;
    private javax.swing.JTextField sName;
    private javax.swing.JTextField sSlogan;
    private javax.swing.JLabel schoolAddress;
    private javax.swing.JLabel schoolLogo;
    private javax.swing.JLabel schoolName;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
byte[] photo = null;
}
