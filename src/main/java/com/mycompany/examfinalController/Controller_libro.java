/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examfinalController;

import com.mycompany.examfinalModelo.Modelo_libreria;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Controller_libro {
    private List<Modelo_libreria> books;

    public Controller_libro() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Modelo_libreria book = new Modelo_libreria(title, author, true);
        books.add(book);
    }

    public List<Modelo_libreria> searchByTitle(String keyword) {
        List<Modelo_libreria> result = new ArrayList<>();
        for (Modelo_libreria book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Modelo_libreria> searchByAuthor(String keyword) {
        List<Modelo_libreria> result = new ArrayList<>();
        for (Modelo_libreria book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void updateAvailability(Modelo_libreria book, boolean available) {
        book.setAvailable(available);
    }

    public void removeBook(Modelo_libreria book) {
        books.remove(book);
    }
}