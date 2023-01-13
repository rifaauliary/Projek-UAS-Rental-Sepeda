/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.pojo.Customer;
import com.mycompany.service.CustomerService;
import com.mycompany.serviceImpl.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tri
 */
public class ManageCustomer {
  static List<Customer> listCustomer = new ArrayList<>();
    static Customer customer;
    static CustomerService customerService;
    static Scanner scanner;
    
    public void viewManageCustomer(String[] args) {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;
        do {
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | Customer Manage");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Display All Customer");
            System.out.println("5. Find Customer by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    char tampil;
                    customer= new Customer();
                    insertCustomer(customer); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        customerService = new CustomerServiceImpl();
                        listCustomer = customerService.findAll();
                        findAllCustomer(listCustomer);
                    }
                break;
                case 2:
                    int updatedIdCustomer;
                    Customer updatedCustomer = new Customer();
                    System.out.println("Masukkan ID: ");
                    updatedIdCustomer = scanner.nextInt();
                    updatedCustomer = findCustomer(updatedIdCustomer);
                    System.out.println("Data Sepeda yang akan diupdate: ");
                    if (updatedCustomer != null) {
                        System.out.println("ID Customer: " + updatedCustomer.getIdCustomer());
                        System.out.println("Nik: " + updatedCustomer.getNamaCustomer());
                        System.out.println("Nama Customer: " + updatedCustomer.getJenisKelamin());
                        System.out.println("Tanggal Lahir: " + updatedCustomer.getTanggalLahir());
                        System.out.println("Jenis Kelamin: " + updatedCustomer.getNomorTelepon());
                        System.out.println("Nomor Telepon: " + updatedCustomer.getNomorTelepon());
                        System.out.println("Alamat: " + updatedCustomer.getAlamat());
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editCustomer(updatedCustomer.getIdCustomer());
                break;
                case 3:
                    int deletedIdCustomer;
                    Customer deletedCustomer = new Customer();
                    char confirmation;
                    customerService = new CustomerServiceImpl();
                    
                    System.out.println("Masukkan ID: ");
                    deletedIdCustomer = scanner.nextInt();
                    deletedCustomer = findCustomer(deletedIdCustomer);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedCustomer != null) {
                            customerService.delete(deletedIdCustomer);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    customerService = new CustomerServiceImpl();
                    listCustomer = customerService.findAll();
                    findAllCustomer(listCustomer);
                break;
                case 5:
                    int searchedIdCustomer;
                    Customer searchedCustomer = new Customer();
                    System.out.println("Masukkan ID: ");
                    searchedIdCustomer = scanner.nextInt();
                    searchedCustomer = findCustomer(searchedIdCustomer);
                    if (searchedCustomer != null) {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("ID Customer\t\t: " + searchedCustomer.getIdCustomer());
                        System.out.println("Nik\t\t: " + searchedCustomer.getNik());
                        System.out.println("Nama Customer\t\t: " + searchedCustomer.getNamaCustomer());
                        System.out.println("Tanggal Lahir\t: " + searchedCustomer.getTanggalLahir());
                        System.out.println("Jenis Kelamin\t: " + searchedCustomer.getJenisKelamin());
                        System.out.println("Nomor Telepon\t\t: " + searchedCustomer.getNomorTelepon());
                        System.out.println("Alamat\t\t: " + searchedCustomer.getAlamat());
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


    private static void findAllCustomer(List<Customer> listCustomer) {
        for (Customer customer: listCustomer) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID Customer \t: " + customer.getIdCustomer());
            System.out.println("Nik\t: " + customer.getNik());
            System.out.println("nama customer\t: " + customer.getNamaCustomer());
            System.out.println("Tanggal lahir\t: " + customer.getTanggalLahir());
            System.out.println("Jenis Kelamin\t: " + customer.getJenisKelamin());
            System.out.println("Nomor telepon\t: " + customer.getNomorTelepon());
            System.out.println("Alamat\t\t: " + customer.getAlamat());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }

    private void insertCustomer(Customer customer) {
       scanner = new Scanner(System.in);
       customerService = new CustomerServiceImpl();
       String  nik, namaCustomer, tanggalLahir, jeniskelamin, nomorTelepon, alamat;
        
        System.out.println("Nik: ");
        nik = scanner.nextLine();
        System.out.println("Nama Customer: ");
        namaCustomer = scanner.nextLine();
        System.out.println("Tanggal Lahir: ");
        tanggalLahir = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Jenis Kelamin: ");
        jeniskelamin = scanner.nextLine();
        System.out.println("Nomor Telepon: ");
        nomorTelepon = scanner.nextLine();
        System.out.println("Alamat: ");
        alamat = scanner.nextLine();
      
        customer.setNamaCustomer(namaCustomer);
        customer.setTanggalLahir(tanggalLahir);
        customer.setJenisKelamin(jeniskelamin);
        customer.setNomorTelepon(nomorTelepon);
        customer.setAlamat(alamat);
      
        
       customerService.create(customer);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }
 

    private Customer findCustomer(int updatedIdCustomer) {
        customer = new Customer();
        customerService = new CustomerServiceImpl();
        customer = customerService.findById(updatedIdCustomer);
    
        return customer; }

    private void editCustomer(Integer idCustomer) {
       scanner = new Scanner(System.in);
       customerService = new CustomerServiceImpl();
 
        String nik, namaCustomer, tanggalLahir,jeniskelamin,  nomorTelepon, alamat, Akun;
        
        System.out.println("Nik: ");
        nik = scanner.nextLine();
        System.out.println("Nama Customer: ");
        namaCustomer = scanner.nextLine();
        System.out.println("Tanggal Lahir: ");
        tanggalLahir = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Jenis Kelamin: ");
        jeniskelamin = scanner.nextLine();
        System.out.println("Nomor Telepon: ");
        nomorTelepon = scanner.nextLine();
        System.out.println("Alamat: ");
        alamat = scanner.nextLine();
        
        customer.setNamaCustomer(namaCustomer);
        customer.setTanggalLahir(tanggalLahir);
        customer.setJenisKelamin(jeniskelamin);
        customer.setNomorTelepon(nomorTelepon);
        customer.setAlamat(alamat);
      
        
        customerService.create(customer);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
    }
}
