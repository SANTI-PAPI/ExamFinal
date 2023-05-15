/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examfinalModelo;

/**
 *
 * @author informatica
 */
public class Modelo_usuario {
    private String username;
    private boolean isAdmin;

    public Modelo_usuario(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }
}
