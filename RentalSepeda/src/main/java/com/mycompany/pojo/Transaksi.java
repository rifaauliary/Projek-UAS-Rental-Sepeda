/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

/**
 *
 * @author berka
 */
public class Transaksi {
    private int orderId;
    private String tanggalOrder;
    private int jumlahSewa;
    private int durasiSewa;
    private int idSepeda;
    private String jenisSpd;
    private int hargaSewa;

    public Transaksi() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(String tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public int getJumlahSewa() {
        return jumlahSewa;
    }

    public void setJumlahSewa(int jumlahSewa) {
        this.jumlahSewa = jumlahSewa;
    }

    public int getDurasiSewa() {
        return durasiSewa;
    }

    public void setDurasiSewa(int durasiSewa) {
        this.durasiSewa = durasiSewa;
    }

    public int getIdSepeda() {
        return idSepeda;
    }

    public void setIdSepeda(int idSepeda) {
        this.idSepeda = idSepeda;
    }

    public String getJenisSpd() {
        return jenisSpd;
    }

    public void setJenisSpd(String jenisSpd) {
        this.jenisSpd = jenisSpd;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    
    
    
}
