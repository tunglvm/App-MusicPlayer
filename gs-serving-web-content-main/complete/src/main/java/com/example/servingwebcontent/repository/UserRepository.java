package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        try {
            return new ArrayList<>(users);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi lấy danh sách người dùng", e);
        }
    }

    public void addUser(User user) {
        try {
            users.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi thêm người dùng", e);
        }
    }

    public void updateUser(User user) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == user.getId()) {
                    users.set(i, user);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi cập nhật người dùng", e);
        }
    }

    public void deleteUser(int id) {
        try {
            users.removeIf(u -> u.getId() == id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi xóa người dùng", e);
        }
    }
}