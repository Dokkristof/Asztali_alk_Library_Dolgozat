/*
* File: BookController.java
* Author: Doktor Kristóf Márk
* Copyright: 2026, Doktor Kristóf Márk
* Group: Szoft II/N
* Date: 2026-06-12
* Github: https://github.com/Dokkristof/
* Licenc: MIT
*/

package com.example;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private final BookService service;
    private final BookView view;

    public BookController(DatabaseAccess db) {
        this.service = new BookService(db);
        this.view = new BookView();
    }

    public void run() throws SQLException {
        service.initializeDatabase();
        List<Book> books = service.getBooks();
        view.printBooks(books);
    }
}
