/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

/**
 *
 * @author berka
 */
public interface AkunRepository<T, ID> {
    T login(String username, String password, String status);
    T registrasi(String nama, String email, String username, String password, String status);
}
