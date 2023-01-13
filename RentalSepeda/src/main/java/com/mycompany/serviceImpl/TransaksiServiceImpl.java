/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviceImpl;

import com.mycompany.pojo.Sepeda;
import com.mycompany.pojo.Transaksi;
import com.mycompany.service.TransaksiService;
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
public class TransaksiServiceImpl implements TransaksiService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Transaksi> findAll() {
        List<Transaksi> listTransaksi = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {  
                Transaksi transaksi = new Transaksi();
                transaksi.setOrderId(rs.getInt("order_id"));
                transaksi.setTanggalOrder(rs.getString("tgl_order"));
                transaksi.setJumlahSewa(rs.getInt("jumlah_sewa"));
                transaksi.setDurasiSewa(rs.getInt("durasi_sewa"));
                transaksi.setIdSepeda(rs.getInt("id_spd"));
                transaksi.setJenisSpd(rs.getString("jenis_spd"));
                transaksi.setHargaSewa(rs.getInt("harga_sewa"));
                /*
                Sepeda sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_spd"));
                sepeda.setJenisSepeda(rs.getString("jenis_spd"));
                sepeda.setHargaSewa(rs.getInt("harga_sewa"));
                */
                listTransaksi.add(transaksi);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return listTransaksi;
    }

    @Override
    public Integer create(Transaksi object) {
        int result = 0;
        String sql = "INSERT INTO transaksi(tgl_order, jumlah_sewa, durasi_sewa,"
                + "id_spd, jenis_spd, harga_sewa) "
                + "VALUES('"+object.getTanggalOrder()+"', "
                + ""+object.getJumlahSewa()+", "
                + ""+object.getDurasiSewa()+", "
                + ""+object.getIdSepeda()+", "
                + "'"+object.getJenisSpd()+"', "
                + ""+object.getHargaSewa()+")";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Transaksi object) {
        int result = 0;
        String sql = "UPDATE transaksi SET tgl_order='"+object.getTanggalOrder()+"',"
                + " jumlah_sewa="+object.getJumlahSewa()+""
                + " durasi_sewa="+object.getDurasiSewa()+""
                + " id_spd="+object.getIdSepeda()+""
                + " jenis_spd='"+object.getJenisSpd()+"'"
                + " harga_sewa="+object.getHargaSewa()+""
                + " WHERE order_id="+object.getOrderId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Transaksi findById(int id) {
        Transaksi transaksi = null;
        String sql = "SELECT * FROM transaksi WHERE order_id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setOrderId(rs.getInt("order_id"));
                transaksi.setTanggalOrder(rs.getString("tgl_order"));
                transaksi.setJumlahSewa(rs.getInt("jumlah_sewa"));
                transaksi.setDurasiSewa(rs.getInt("durasi_sewa"));
                transaksi.setIdSepeda(rs.getInt("id_spd"));
                transaksi.setJenisSpd(rs.getString("jenis_spd"));
                transaksi.setHargaSewa(rs.getInt("harga_sewa"));
                
                /*
                Sepeda sepeda = new Sepeda();
                sepeda.setIdSepeda(rs.getInt("id_spd"));
                sepeda.setJenisSepeda(rs.getString("jenis_spd"));
                sepeda.setHargaSewa(rs.getInt("harga_sewa"));
                */
                
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return transaksi;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM transaksi WHERE order_id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
