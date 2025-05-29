package musicPlayer;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    // Create
    public void addUser(User user) {
        if (user != null && getUserByID(user.getUserID()) == null) {
            users.add(user);
        } else {
            System.out.println("User đã tồn tại hoặc thông tin không hợp lệ.");
        }
    }

    // Read
    public void printUserList() {
        System.out.println("Danh sách user:");
        if (users.isEmpty()) {
            System.out.println("Không có user nào.");
        }
        for (User u : users) {
            u.displayUserInfo();
        }
    }

    // Update
    public boolean editUserName(String userID, String newName) {
        User user = getUserByID(userID);
        if (user != null) {
            user.setName(newName);
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteUser(String userID) {
        User user = getUserByID(userID);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    // Helper: Get user by ID
    public User getUserByID(String userID) {
        for (User u : users) {
            if (u.getUserID().equals(userID)) {
                return u;
            }
        }
        return null;
    }

    // Get all users
    public ArrayList<User> getUsers() {
        return users;
    }
}
