/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviceImpl;

import com.mycompany.pojo.Sepeda;
import com.mycompany.service.SepedaService;
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
public class SepedaServiceImpl implements SepedaService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Sepeda> findAll() {
        List<Sepeda> listSepeda = new ArrayList<>();
        String sql = "SELECT * FROM sepeda";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {   
                Sepeda sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_spd"));
                sepeda.setJenisSepeda(rs.getString("jenis_spd"));
                sepeda.setJumlahSepeda(rs.getInt("jumlah_sepeda"));
                sepeda.setHargaSewa(rs.getInt("harga_sewa"));
                listSepeda.add(sepeda);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SepedaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listSepeda;
    }

    @Override
    public Integer create(Sepeda object) {
        int result = 0;
        String sql = "INSERT INTO sepeda(jenis_spd, jumlah_sepeda, harga_sewa) "
                + "VALUES('"+object.getJenisSepeda()+"', "
                + ""+object.getJumlahSepeda()+", "
                + ""+object.getHargaSewa()+")";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SepedaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Sepeda object) {
        int result = 0;
        String sql = "UPDATE sepeda SET id_spd=" + object.getIdSepeda() 
                + ", jumlah_sepeda=" + object.getJumlahSepeda() + ", harga_sewa=" 
                + object.getHargaSewa() + " WHERE jenis_spd = '" + object.getJenisSepeda() + "'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SepedaServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Sepeda findById(int id) {
        Sepeda sepeda = null;
        String sql = "SELECT * FROM sepeda WHERE id_spd="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_spd"));
                sepeda.setJenisSepeda(rs.getString("jenis_spd"));
                sepeda.setJumlahSepeda(rs.getInt("jumlah_sepeda"));
                sepeda.setHargaSewa(rs.getInt("harga_sewa"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SepedaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return sepeda;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM sepeda WHERE id_spd="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(SepedaServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
