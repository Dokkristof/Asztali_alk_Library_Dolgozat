/*
* File: BookService.java
* Author: Doktor Kristóf Márk
* Copyright: 2026, Doktor Kristóf Márk
* Group: Szoft II/N
* Date: 2026-06-12
* Github: https://github.com/Dokkristof/
* Licenc: MIT
*/

package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final DatabaseAccess db;

    public BookService(DatabaseAccess db) {
        this.db = db;
    }

    public void initializeDatabase() throws SQLException {
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "title VARCHAR(100), " +
                "author VARCHAR(100), " +
                "year INTEGER, " +
                "pages INTEGER)"
            );

            boolean isEmpty = false;
            try (ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM books")) {
                if (result.next()) {
                    if (result.getInt(1) == 0) {
                        isEmpty = true;
                    }
                }
            }

            if (isEmpty) {
                statement.executeUpdate(
                    "INSERT INTO books (id, title, author, year, pages) VALUES " +
                    "(1, 'Egri csillagok', 'Gárdonyi Géza', 1901, 580), " +
                    "(2, 'A Pál utcai fiúk', 'Molnár Ferenc', 1906, 288), " +
                    "(3, 'Légy jó mindhalálig', 'Móricz Zsigmond', 1920, 410), " +
                    "(4, 'Tüskevár', 'Fekete István', 1957, 320), " +
                    "(5, 'Abigél', 'Szabó Magda', 1970, 450)"
                );
            }
        }
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(
                 "SELECT id, title, author, year FROM books ORDER BY id")) {
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                int year = result.getInt("year");

                Book book = new Book(id, title, author, year);
                books.add(book);
            }
        }
        return books;
    }
}
