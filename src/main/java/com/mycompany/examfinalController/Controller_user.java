/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examfinalController;
import com.mycompany.examfinalModelo.Modelo_usuario;
import java.util.ArrayList;
import java.util.List;

public class Controller_user {
    private List<Modelo_usuario> users;

    public Controller_user() {
        users = new ArrayList<>();
    }

    public void addUser(String username, boolean isAdmin) {
        Modelo_usuario user = new Modelo_usuario(username, isAdmin);
        users.add(user);
    }

    public Modelo_usuario getUserByUsername(String username) {
        for (Modelo_usuario user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}