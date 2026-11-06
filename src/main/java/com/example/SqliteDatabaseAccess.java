/*
* File: SqliteDatabaseAccess.java
* Author: Doktor Kristóf Márk
* Copyright: 2026, Doktor Kristóf Márk
* Group: Szoft II/N
* Date: 2026-06-12
* Github: https://github.com/Dokkristof/
* Licenc: MIT
*/

package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public class SqliteDatabaseAccess implements DatabaseAccess {
    private final SQLiteDataSource ds;

    public SqliteDatabaseAccess() {
        ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:books.sqlite");
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}