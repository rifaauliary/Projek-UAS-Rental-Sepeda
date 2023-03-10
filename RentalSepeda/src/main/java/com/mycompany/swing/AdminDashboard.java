/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.swing;

import com.mycompany.pojo.Admin;
import com.mycompany.pojo.Akun;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author berka
 */
public class AdminDashboard extends javax.swing.JFrame {
    Akun akun;
    Admin admin;

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    
    public Akun getAkunInfo(Akun akn) {
        akun = akn;
        lblInfo.setText(akun.getUsername());
        return akun;
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
        lblInfo = new javax.swing.JLabel();
        btnManageSepeda = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnManageTransaksi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(196, 255, 216));
        jPanel1.setLayout(null);

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblInfo);
        lblInfo.setBounds(210, 100, 130, 20);

        btnManageSepeda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManageSepeda.setText("MANAGE SEPEDA");
        btnManageSepeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSepedaActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageSepeda);
        btnManageSepeda.setBounds(150, 230, 250, 50);

        btnManageCustomer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManageCustomer.setText("MANAGE CUSTOMER");
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageCustomer);
        btnManageCustomer.setBounds(150, 150, 250, 50);

        jPanel2.setBackground(new java.awt.Color(136, 232, 200));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ADMIN DASHBOARD");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(150, 20, 260, 29);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 580, 70);

        btnManageTransaksi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManageTransaksi.setText("MANAGE TRANSAKSI");
        btnManageTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btnManageTransaksi);
        btnManageTransaksi.setBounds(150, 310, 250, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("SELAMAT DATANG");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 70, 140, 30);

        btnLogout.setBackground(new java.awt.Color(136, 232, 200));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);
        btnLogout.setBounds(230, 390, 90, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(575, 484));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        // TODO add your handling code here:
        ManageCustomer manageCustomer = new ManageCustomer();
        manageCustomer.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageSepedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSepedaActionPerformed
        // TODO add your handling code here:
        ManageSepeda manageSepeda = new ManageSepeda();
        manageSepeda.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManageSepedaActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah Anda yakin mau keluar?", "Warning", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnManageTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTransaksiActionPerformed
        // TODO add your handling code here:
        ManageTransaksi manageTransaksi = new ManageTransaksi();
        manageTransaksi.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManageTransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageSepeda;
    private javax.swing.JButton btnManageTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
}
