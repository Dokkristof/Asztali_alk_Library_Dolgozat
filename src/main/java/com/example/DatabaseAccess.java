/*
* File: DatabaseAccess.java
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

public interface DatabaseAccess {
    Connection getConnection() throws SQLException;
}
