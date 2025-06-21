package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class aivenConnection {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // Lấy thông tin kết nối từ biến môi trường
        String url = System.getenv("AIVEN_JDBC_URL");
        String username = System.getenv("AIVEN_DB_USER");
        String password = System.getenv("AIVEN_DB_PASSWORD");

        System.out.println("JDBC URL: " + url);
        System.out.println("User: " + username);


        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}