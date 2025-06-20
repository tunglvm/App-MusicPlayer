package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.database.aivenConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private aivenConnection db = new aivenConnection();

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("userId"));
                user.setUserName(rs.getString("username"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}