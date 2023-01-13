/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;


import com.mycompany.pojo.Sepeda;
import com.mycompany.service.SepedaService;
import com.mycompany.serviceImpl.SepedaServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tri
 */
public class ManageSepeda {
    static List<Sepeda> listSepeda = new ArrayList<>();
    static Sepeda sepeda;
    static SepedaService sepedaService;
    static Scanner scanner;
    private int deletedId;
    
    public void viewSepedaManage(String[] args) {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;
        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | Sepeda Manage");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert Sepeda");
            System.out.println("2. Update Sepeda");
            System.out.println("3. Delete Sepeda");
            System.out.println("4. Display All Sepeda");
            System.out.println("5. Find Sepeda by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
             menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    char tampil;
                    sepeda = new Sepeda();
                    insertSepeda(sepeda); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        sepedaService = new SepedaServiceImpl();
                        listSepeda = sepedaService.findAll();
                        findAllSepeda(listSepeda);
                    }
                break;
                case 2:
                    int updatedIdSepeda;
                    Sepeda updatedSepeda = new Sepeda();
                    System.out.println("Masukkan ID Sepeda: ");
                    updatedIdSepeda = scanner.nextInt();
                    updatedSepeda = findSepeda(updatedIdSepeda);
                    System.out.println("Data obat yang akan diupdate: ");
                    if (updatedSepeda != null) {
                        System.out.println("ID Sepeda: " + updatedSepeda.getIdSepeda());
                        System.out.println("Jenis Sepeda: " + updatedSepeda.getJenisSepeda());
                        System.out.println("Harga Sewa: " + updatedSepeda.getHargaSewa());
                        System.out.println("Jumlah Sepeda: " + updatedSepeda.getJumlahSepeda());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editSepeda(updatedSepeda.getIdSepeda());
                break;
                case 3:
                    int deletedIdSepeda;
                    Sepeda deletedSepeda = new Sepeda();
                    char confirmation;
                    sepedaService = new SepedaServiceImpl();
                    
                    System.out.println("Masukkan ID Obat: ");
                    deletedIdSepeda= scanner.nextInt();
                    deletedSepeda = findSepeda(deletedIdSepeda);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedSepeda != null) {
                            sepedaService.delete(deletedId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    sepedaService = new SepedaServiceImpl();
                    listSepeda = sepedaService.findAll();
                    findAllSepeda(listSepeda);
                break;
                case 5:
                    int searchedIdSepeda;
                    Sepeda searchedSepeda = new Sepeda();
                    System.out.println("Masukkan ID Obat: ");
                    searchedIdSepeda = scanner.nextInt();
                    searchedSepeda = findSepeda(searchedIdSepeda);
                    if (searchedSepeda != null) {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("ID Sepeda\t\t: " + searchedSepeda.getIdSepeda());
                        System.out.println("jenis Sepeda\t: " + searchedSepeda.getJenisSepeda());
                        System.out.println("Harga Sewa\t\t: " + searchedSepeda.getHargaSewa());
                        System.out.println("Jumlah Sepeda\t\t: " + searchedSepeda.getJumlahSepeda());
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
    private static void findAllSepeda(List<Sepeda> listSepeda) {
        for (Sepeda sepeda: listSepeda) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID Sepeda \t: " + sepeda.getIdSepeda());
            System.out.println("Jenis Sepeda\t: " + sepeda.getJenisSepeda());
            System.out.println("Harga Sewa\t: " + sepeda.getHargaSewa());
            System.out.println("Jumlah Sepeda\t: " + sepeda.getJumlahSepeda());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }

    private void insertSepeda(Sepeda sepeda) {
       scanner = new Scanner(System.in);
        sepedaService = new SepedaServiceImpl();
        String jenisSepeda;
        int hargaSewa;
        int jumlahSepeda, idSepeda;
        
        System.out.println("Id Sepeda: ");
        idSepeda = scanner.nextInt();
        System.out.println("Jenis Sepeda: ");
        jenisSepeda = scanner.nextLine();
        System.out.println("Harga sewa: ");
        hargaSewa = scanner.nextInt();
        System.out.println("Jumlah Sepeda: ");
        jumlahSepeda = scanner.nextInt();
        
        sepeda.setJenisSepeda(jenisSepeda);
        sepeda.setHargaSewa(hargaSewa);
        sepeda.setJumlahSepeda(jumlahSepeda);
        
        sepedaService.create(sepeda);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }

    private Sepeda findSepeda(int updatedIdSepeda) {
        sepeda = new Sepeda();
        sepedaService = new SepedaServiceImpl();
        sepeda= sepedaService.findById(updatedIdSepeda);
    
        return sepeda;
}

    private void editSepeda(Integer idSepeda) {
        scanner = new Scanner(System.in);
        sepedaService = new SepedaServiceImpl();
        sepeda = new Sepeda();
        String jenisSepeda;
        int hargaSewa;
        int jumlahSepeda;
        
        System.out.println("Jenis Sepeda: ");
        jenisSepeda = scanner.nextLine();
        System.out.println("Harga sewa: ");
        hargaSewa = scanner.nextInt();
        System.out.println("Jumlah Sepeda: ");
        jumlahSepeda = scanner.nextInt();
        
        sepeda.setJenisSepeda(jenisSepeda);
        sepeda.setHargaSewa(hargaSewa);
        sepeda.setJumlahSepeda(jumlahSepeda);
        
        System.out.println("ID..." + sepeda.getIdSepeda());
        
        sepedaService.update(sepeda);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
}

}  
