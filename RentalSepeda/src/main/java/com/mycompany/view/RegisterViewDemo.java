/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.pojo.Akun;
import com.mycompany.service.AkunService;
import com.mycompany.serviceImpl.AkunServiceImpl;
import java.util.Scanner;

/**
 *
 * @author berka
 */
public class RegisterViewDemo {
    public static void registrasi() {
        Scanner scanner = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Akun akun;
        
        String nama, email, username, password, status;
        boolean regis = false;
        
        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|                 REGISTRASI                |");
            System.out.println("+-------------------------------------------+");
            System.out.print("| Nama      : ");
            nama = scanner.nextLine();
            System.out.print("| Email     : ");
            email = scanner.nextLine();
            System.out.print("| Username  : ");
            username = scanner.nextLine();
            System.out.print("| Password  : ");
            password = scanner.nextLine();
            System.out.print("| Status    : ");
            status = scanner.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            akun = akunService.registrasi(nama, email, username, password, status);
            if (akun != null) {
                regis = true;
                System.out.println("Registrasi Berhasil!");
                LoginViewDemo.login();
            } else {
                System.out.println("Registrasi gagal, periksa kembali kelengkapan data Anda!");
            }
        } while (!regis);
        
    }
}
