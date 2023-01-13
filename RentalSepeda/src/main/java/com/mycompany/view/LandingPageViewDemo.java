/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author berka
 */
public class LandingPageViewDemo {
    public static void main(String[] args) {
        landingPage();
    }

    private static void landingPage() {
        int menu = 0;
        boolean exit = false;
        char pilihan;
        Scanner scanner;
        
        do {
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("|                     SEWA SEPEDA DI APLIKASI BIKE-BIKE AJAH                |");
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("| Selamat datang, silahkan melakukan login atau registrasi terlebih dahulu! |");
            System.out.println("| [1] Login                                                                 |");
            System.out.println("| [2] Register                                                                 |");
            System.out.println("| [3] Exit                                                                  |");
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("");
            System.out.print("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            
            try {
                menu = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Pilihan harus dalam Angka   : " +e);
            }
            
            switch (menu) {
                case 1:
                    LoginViewDemo.login();
                break;
                case 2:
                    RegisterViewDemo.registrasi();
                break;
                case 3:
                    System.out.println("Keluar aplikasi......");
                    System.exit(0);
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                    System.out.println("Silahkan coba lagi!");
                break;
            }
            System.out.println("");
            System.out.print("Apakah Anda ingin melanjutkan? [y/n] : ");
            scanner = new Scanner(System.in);
            System.out.println("");
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                exit = true;
            }
            
        } while (!exit);
        System.out.println("Terima kasih sudah menggunakan aplikasi Bike-Bike Ajah ^U^");
        System.exit(0);
    }
}
