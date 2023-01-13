/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviceImpl;

import com.mycompany.pojo.Customer;
import com.mycompany.service.CustomerService;
import com.mycompany.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berka
 */
public class CustomerServiceImpl implements CustomerService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    private Customer customer;

    @Override
    public List<Customer> findAll() {
        List<Customer> listCustomer = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {  
                customer = new Customer();
                customer.setIdCustomer(rs.getInt("id_cust"));
                customer.setIdAkun(rs.getInt("id_akun"));
                customer.setNik(rs.getString("nik"));
                customer.setNamaCustomer(rs.getString("nama_cust"));
                customer.setTanggalLahir(rs.getString("tgl_lhr"));
                customer.setJenisKelamin(rs.getString("gender"));
                customer.setNomorTelepon(rs.getString("nomor_telp"));
                customer.setAlamat(rs.getString("alamat"));
                listCustomer.add(customer);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listCustomer;
    }

    @Override
    public Integer create(Customer object) {
        int result = 0;
        String sql = "INSERT INTO customer(nik, nama_cust, tgl_lhr, gender, nomor_telp, alamat) "
                + "VALUES('"+object.getNik()+"', "
                + "'"+object.getNamaCustomer()+"', "
                + "'"+object.getTanggalLahir()+"', "
                + "'"+object.getJenisKelamin()+"', "
                + "'"+object.getNomorTelepon()+"', "
                + "'"+object.getAlamat()+"')";
        
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Customer object) {
        int result = 0;
        String sql = "UPDATE customer SET nik='"+object.getNik()+"', "
                + "nama_cust='"+object.getNamaCustomer()+"', "
                + "tgl_lhr='"+object.getTanggalLahir()+"', "
                + "gender='"+object.getJenisKelamin()+"', "
                + "nomor_telp='"+object.getNomorTelepon()+"', "
                + "alamat='"+object.getAlamat()+" "
                + "WHERE id_cust="+object.getIdCustomer()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE id_cust="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                customer = new Customer();
                customer.setIdCustomer(rs.getInt("id_cust"));
                customer.setIdAkun(rs.getInt("id_akun"));
                customer.setNik(rs.getString("nik"));
                customer.setNamaCustomer(rs.getString("nama_cust"));
                customer.setTanggalLahir(rs.getString("tgl_lhr"));
                customer.setJenisKelamin(rs.getString("gender"));
                customer.setNomorTelepon(rs.getString("nomor_telp"));
                customer.setAlamat(rs.getString("alamat"));
                
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM customer WHERE id_cust="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
