/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.swing;
import com.mycompany.service.CustomerService;
import com.mycompany.pojo.Customer;
import com.mycompany.serviceImpl.CustomerServiceImpl;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rifa
 */
public class ProfileCustomer extends javax.swing.JFrame {
    CustomerService customerService = new CustomerServiceImpl();

    /**
     * Creates new form ProfileCustomer
     */
                 
    public ProfileCustomer() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
    }
    
    public void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    
    private void emptyField() {
        txtNIK.setText("");
        txtNama.setText("");
        dcTanggal.setCalendar(null);
        bgGender.clearSelection();
        txtNoTlp.setText("");
        txtAlamat.setText("");
    }
    
    private void loadData() {
        customerService = new CustomerServiceImpl();
        List<Customer> listCustomer = new ArrayList<>();
        listCustomer = customerService.findAll();
        Object[][] objectCustomer = new Object[listCustomer.size()][8];
        
        int counter = 0;
        
        for (Customer customer :listCustomer) {
            objectCustomer[counter][0] = customer.getIdCustomer();
            objectCustomer[counter][1] = customer.getIdAkun();
            objectCustomer[counter][2] = customer.getNik();
            objectCustomer[counter][3] = customer.getNamaCustomer();
            objectCustomer[counter][4] = customer.getTanggalLahir();
            objectCustomer[counter][5] = customer.getJenisKelamin();
            objectCustomer[counter][6] = customer.getNomorTelepon();
            objectCustomer[counter][7] = customer.getAlamat();
            counter++;
        }
    }
    
    /*
    private void loadData() {
        String jenisKelamin = null;
        Customer customer = new Customer();
        txtNIK.setText(customer.getNik());
        txtNama.setText(customer.getNamaCustomer());
        dcTanggal.setDateFormatString(customer.getTanggalLahir());
        if (jenisKelamin.equals("Laki - Laki")) {
            rbLakiLaki.setSelected(true);
        }
        if (jenisKelamin.equals("Perempuan")) {
            rbPerempuan.setSelected(true);
        }
        txtNoTlp.setText(customer.getNomorTelepon());
        txtAlamat.setText(customer.getAlamat());
    }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        dcTanggal = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        rbPerempuan = new javax.swing.JRadioButton();
        rbLakiLaki = new javax.swing.JRadioButton();
        txtNoTlp = new javax.swing.JTextField();
        txtNIK = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        btnUpdate.setBackground(new java.awt.Color(136, 232, 200));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 51, 0));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(400, 470, 120, 30);
        jPanel1.add(dcTanggal);
        dcTanggal.setBounds(330, 170, 240, 30);

        btnSave.setBackground(new java.awt.Color(136, 232, 200));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 51, 0));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(220, 470, 120, 30);

        btnBack.setBackground(new java.awt.Color(136, 232, 200));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 51, 0));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(40, 470, 120, 30);

        bgGender.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(11, 117, 84));
        rbPerempuan.setText("Perempuan");
        rbPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanActionPerformed(evt);
            }
        });
        jPanel1.add(rbPerempuan);
        rbPerempuan.setBounds(170, 430, 130, 24);

        bgGender.add(rbLakiLaki);
        rbLakiLaki.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        rbLakiLaki.setForeground(new java.awt.Color(11, 117, 84));
        rbLakiLaki.setText("Laki - Laki");
        rbLakiLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiLakiActionPerformed(evt);
            }
        });
        jPanel1.add(rbLakiLaki);
        rbLakiLaki.setBounds(40, 430, 110, 24);

        txtNoTlp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNoTlp);
        txtNoTlp.setBounds(40, 330, 250, 30);

        txtNIK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNIK);
        txtNIK.setBounds(40, 250, 250, 30);

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNama);
        txtNama.setBounds(40, 170, 250, 30);

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(330, 330, 240, 80);

        icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\berka\\Downloads\\PROFILE COSTUMER.png")); // NOI18N
        jPanel1.add(icon);
        icon.setBounds(0, 0, 650, 550);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 550);

        setSize(new java.awt.Dimension(664, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbLakiLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiLakiActionPerformed
        // TODO add your handling code here:   
        gender = "Laki - Laki";
    }//GEN-LAST:event_rbLakiLakiActionPerformed

    private void rbPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanActionPerformed
        // TODO add your handling code here:
        gender = "Perempuan";
    }//GEN-LAST:event_rbPerempuanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String nik, namaCustomer, tanggalLahir, jenisKelamin, nomorTelepon, alamat;
        customerService = new CustomerServiceImpl();
        
        nik = txtNIK.getText();
        namaCustomer = txtNama.getText();
        Date date = dcTanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tanggalLahir = dateFormat.format(date);
        jenisKelamin = gender;
        nomorTelepon = txtNoTlp.getText();
        alamat = txtAlamat.getText();
        
        Customer customer = new Customer();
        customer.setNik(nik);
        customer.setNamaCustomer(namaCustomer);
        customer.setTanggalLahir(tanggalLahir);
        customer.setJenisKelamin(jenisKelamin);
        customer.setNomorTelepon(nomorTelepon);
        customer.setAlamat(alamat);
        
        customerService.create(customer);
        JOptionPane.showMessageDialog(null, "Data berhasil dibuat!");
        loadData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CustomerDashboard customerDashboard = new CustomerDashboard();
        customerDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nik, namaCustomer, tanggalLahir, jenisKelamin, nomorTelepon, alamat;
        customerService = new CustomerServiceImpl();
        
        nik = txtNIK.getText();
        namaCustomer = txtNama.getText();
        Date date = dcTanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        tanggalLahir = dateFormat.format(date);
        jenisKelamin = gender;
        nomorTelepon = txtNoTlp.getText();
        alamat = txtAlamat.getText();
        
        Customer customer = new Customer();
        customer.setNik(nik);
        customer.setNamaCustomer(namaCustomer);
        customer.setTanggalLahir(tanggalLahir);
        customer.setJenisKelamin(jenisKelamin);
        customer.setNomorTelepon(nomorTelepon);
        customer.setAlamat(alamat);
        
        customerService.update(customer);
        JOptionPane.showMessageDialog(null, "Data data berhasil diupdate!");
        loadData();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(ProfileCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dcTanggal;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLakiLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTlp;
    // End of variables declaration//GEN-END:variables
    private String gender;
    
}
