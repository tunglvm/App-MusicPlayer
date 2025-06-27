package musicPlayer;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users = new ArrayList<>();

    // Thêm người dùng vào danh sách
    public boolean addUser(User user) {
        try {
            if (user == null) {
                throw new IllegalArgumentException("Người dùng không thể là null.");
            }
            users.add(user);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong addUser: " + e.getMessage());
            return false;
        }
    }

    // Sửa tên người dùng theo userID
    public boolean editUser(String newName, String userID) {
        try {
            if (newName == null || newName.isEmpty()) {
                throw new IllegalArgumentException("Tên mới không thể là null hoặc rỗng.");
            }
            for (User user : users) {
                if (user.getUserID().equals(userID)) {
                    user.setName(newName);
                    return true;
                }
            }
            System.out.println("Không tìm thấy người dùng với ID: " + userID);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong editUser: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong editUser: " + e.getMessage());
            return false;
        }
    }

    // Xóa người dùng theo userID
    public boolean deleteUser(String userID) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserID().equals(userID)) {
                    users.remove(i);
                    return true;
                }
            }
            System.out.println("Không tìm thấy người dùng với ID: " + userID);
            return false;
        } catch (Exception e) {
            System.out.println("Lỗi trong deleteUser: " + e.getMessage());
            return false;
        }
    }

    // In danh sách người dùng
    public void printUserList() {
        if (users.isEmpty()) {
            System.out.println("Danh sách người dùng rỗng.");
            return;
        }
        for (User user : users) {
            System.out.println("User ID: " + user.getUserID() + " Name: " + user.getName());
        }
    }
}
