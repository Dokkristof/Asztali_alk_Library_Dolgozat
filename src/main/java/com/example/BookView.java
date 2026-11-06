/*
* File: BookView.java
* Author: Doktor Kristóf Márk
* Copyright: 2026, Doktor Kristóf Márk
* Group: Szoft II/N
* Date: 2026-06-12
* Github: https://github.com/Dokkristof/
* Licenc: MIT
*/

package com.example;

import java.util.List;

public class BookView {
    public void printBooks(List<Book> books) {
        System.out.printf("%-4s %-23s %-23s %-5s%n", "Id", "Cím", "Szerző", "Év");

        for (Book book : books) {
            System.out.printf("%-4d %-23s %-23s %-5d%n",
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear()
            );
        }
    }
}