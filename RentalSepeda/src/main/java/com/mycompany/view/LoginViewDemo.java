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
public class LoginViewDemo {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        Akun akun;
        
        String username, password, status;
        boolean login = false;
        
        do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|                   LOGIN                   |");
            System.out.println("+-------------------------------------------+");
            System.out.print("| Username  : ");
            username = scanner.nextLine();
            System.out.print("| Password  : ");
            password = scanner.nextLine();
            System.out.print("| Status    : ");
            status = scanner.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            akun = akunService.login(username, password, status);
            if (status.equals("Admin") || status.equals("admin")) {
                login = true;
                akun.setLoginStatus(login);
                System.out.println("Login Berhasil!");
                AdminViewDemo.menuAdmin();
            } else if (status.equals("Customer") || status.equals("customer")) {
                login = true;
                akun.setLoginStatus(true);
                System.out.println("Login Berhasil!");
                CustomerViewDemo.menuCustomer();
            } else {
                System.out.println("Username atau password yang Anda masukkan salah, silahkan coba lagi...!");
            }
        } while (!login);
    }
}
