package com.example.travelexpertsjava;

import java.sql.*;

public final class DBConn {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String user = "torres", password = "pass123456", url = "jdbc:mysql://localhost:3306/travelexperts?allowMultiQueries=true";

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
