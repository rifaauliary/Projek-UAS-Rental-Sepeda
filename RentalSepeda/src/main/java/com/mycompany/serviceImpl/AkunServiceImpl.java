/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviceImpl;

import com.mycompany.pojo.Akun;
import com.mycompany.service.AkunService;
import com.mycompany.utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berka
 */
public class AkunServiceImpl implements AkunService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public Akun login(String username, String password, String status) {
        Akun akun = null;
        String sql = "SELECT nama, email, username, password, status_akun "
                + "FROM akun "
                + "WHERE username = '" +username+"' "
                + "AND password = '" +password+"' "
                + "AND status_akun = '" +status+"' ";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                akun = new Akun();
                akun.setNama(rs.getString("nama"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setStatusAkun(rs.getString("status_akun"));
                akun.setStatusAkun(status);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AkunServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return akun;
    }   

    @Override
    public Akun registrasi(String nama, String email, String username, String password, String status) {
        int result = 0;
        Akun akun = null;
        String sql = "INSERT INTO Akun (nama, email, username, password, status_akun) VALUES ("
                + "'" + nama + "', "
                + "'" + email + "', "
                + "'" + username + "', "
                + "'" + password + "', "
                + "'" + status + "')";
                
                
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AkunServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return akun;
    }
    
    public Object registrasiCustomer(String nama, String email, String username, String password, String status) {
        int result = 0;
        String sql = "INSERT INTO Akun (nama, email, username, password, status_akun) VALUES ("
                + "'" + nama + "', "
                + "'" + email + "', "
                + "'" + username + "', "
                + "'" + password + "', "
                + "'" + status + "')";
                
                
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AkunServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
