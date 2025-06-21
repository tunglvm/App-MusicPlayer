package com.example.servingwebcontent.database;

import java.sql.Connection;

public class TestAivenConnection {
    public static void main(String[] args) {
        aivenConnection conn = new aivenConnection();
        try (Connection connection = conn.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}