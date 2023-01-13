/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.pojo.Transaksi;
import com.mycompany.service.TransaksiService;
import com.mycompany.serviceImpl.TransaksiServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tri
 */
public class ManageTransaksi {
    static List<Transaksi> listTransaksi = new ArrayList<>();
    static Transaksi transaksi;
    static TransaksiService transaksiService;
    static Scanner scanner;
    
    public static void viewManageTransaksi() {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;
     do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | TRANSAKSI MANAGE");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert Transaksi");
            System.out.println("2. Update Transaksi");
            System.out.println("3. Delete Transaksi");
            System.out.println("4. Display All Transaki");
            System.out.println("5. Find Transaksi by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    char tampil;
                    transaksi = new Transaksi();
                    insertTransaksi(transaksi); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        transaksiService = new TransaksiServiceImpl();
                        listTransaksi = transaksiService.findAll();
                        findAllTransaksi(listTransaksi);
                    }
                break;
                case 2:
                    int updatedOrderId;
                    Transaksi updatedTransaksi = new Transaksi();
                    System.out.println("Masukkan ID Transaksi: ");
                    updatedOrderId = scanner.nextInt();
                    updatedTransaksi = findTransaksi(updatedOrderId);
                    System.out.println("Data Transaksi yang akan diupdate: ");
                    if (updatedTransaksi != null) {
                        System.out.println("Order Id: " + updatedTransaksi.getOrderId());
                        System.out.println("Tanggal Order: " + updatedTransaksi.getTanggalOrder());
                        System.out.println("Jumlah Sewa: " + updatedTransaksi.getJumlahSewa());
                        System.out.println("Durasi Sewa: " + updatedTransaksi.getDurasiSewa());
                        System.out.println("Id Sepeda: " + updatedTransaksi.getIdSepeda());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editTransaksi(updatedTransaksi.getOrderId());
                break;
                case 3:
                    int deletedOrderId;
                    Transaksi deletedTransaksi = new Transaksi();
                    char confirmation;
                    transaksiService = new TransaksiServiceImpl();
                    
                    System.out.println("Masukkan ID Transaksi: ");
                    deletedOrderId = scanner.nextInt();
                    deletedTransaksi = findTransaksi(deletedOrderId);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedTransaksi != null) {
                            transaksiService.delete(deletedOrderId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    transaksiService = new TransaksiServiceImpl();
                    listTransaksi = transaksiService.findAll();
                    findAllTransaksi(listTransaksi);
                break;
                case 5:
                    int searchedOrderId;
                    Transaksi searchedTransaksi = new Transaksi();
                    System.out.println("Masukkan ID Transaksi: ");
                    searchedOrderId = scanner.nextInt();
                    searchedTransaksi = findTransaksi(searchedOrderId);
                    if (searchedTransaksi != null) {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Order Id\t\t: " + searchedTransaksi.getOrderId());
                        System.out.println("Tanggal Order\t\t: " + searchedTransaksi.getTanggalOrder());
                        System.out.println("Jumlah Sewa\t\t: " + searchedTransaksi.getJumlahSewa());
                        System.out.println("Durasi Sewa\t\t: " + searchedTransaksi.getDurasiSewa());
                        System.out.println("-----------------------------------------------------------------");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
            System.out.println("");
            System.out.println("Apakah ingin melanjutkan? y/n: ");
            scanner = new Scanner(System.in);
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                keluar = true;
            }
            
        } while (!keluar);
        System.out.println("Kembali ke menu utama!");
    }

    private static void insertTransaksi(Transaksi transaksi) {
        scanner = new Scanner(System.in);
        transaksiService = new TransaksiServiceImpl();
        String tanggalOrder;
        int orderId,jumlahSewa, durasiSewa; 
        
        System.out.println("Order Id: ");
        orderId = scanner.nextInt();
        System.out.println("Tanggal Order: ");
        tanggalOrder = scanner.nextLine();
        System.out.println("Jumlah Sewa: ");
        jumlahSewa = scanner.nextInt();
        System.out.println("Durasi Sewa: ");
        durasiSewa = scanner.nextInt();
        
        
        transaksi.setOrderId(orderId);
        transaksi.setTanggalOrder(tanggalOrder);
        transaksi.setJumlahSewa(jumlahSewa);
        transaksi.setDurasiSewa(durasiSewa);
        
        transaksiService.create(transaksi);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }

    private static void findAllTransaksi(List<Transaksi> listTransaksi) {
       for (Transaksi transaksi : listTransaksi) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Order Id\t\t: " + transaksi.getOrderId());
            System.out.println("Tanggal Order\t: " + transaksi.getTanggalOrder());
            System.out.println("Jumlah Sewa\t\t: " + transaksi.getJumlahSewa());
            System.out.println("Durasi Sewa\t\t: " + transaksi.getDurasiSewa());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }

    private static Transaksi findTransaksi(int updatedIdTransaksi) {
        transaksi = new Transaksi();
        transaksiService = new TransaksiServiceImpl();
        transaksi= transaksiService.findById(updatedIdTransaksi);
    
        return transaksi; }

    private static void editTransaksi(int orderId) {
        scanner = new Scanner(System.in);
        transaksiService = new TransaksiServiceImpl();
        transaksi = new Transaksi();
        String tanggalOrder;
        int jumlahSewa, durasiSewa; 
        
        
        System.out.println("Tanggal Order: ");
        tanggalOrder = scanner.nextLine();
        System.out.println("Jumlah Sewa: ");
        jumlahSewa= scanner.nextInt();
        System.out.println("Durasi Sewa: ");
        durasiSewa= scanner.nextInt();
        
        
        transaksi.setOrderId(orderId);
        transaksi.setTanggalOrder(tanggalOrder);
        transaksi.setJumlahSewa(jumlahSewa);
        transaksi.setDurasiSewa(durasiSewa);
        
        
        System.out.println("ID..." + transaksi.getOrderId());
        
        transaksiService.update(transaksi);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
    }

}
