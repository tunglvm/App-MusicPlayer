package musicPlayer;

import java.util.ArrayList;

public class UserList {
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> addUser(User user) {
        if (user != null && getUserByID(user.getUserID()) == null) {
            users.add(user);
        } else {
            System.out.println("User đã tồn tại hoặc thông tin không hợp lệ.");
        }
        return users;
    }

    public ArrayList<User> editUserName(String userID, String newName) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                user.setName(newName);
            }
        }
        return users;
    }

    public ArrayList<User> deleteUser(String userID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserID().equals(userID)) {
                users.remove(i);
                break;
            }
        }
        return users;
    }

    public void printUserList() {
        for (User user : users) {
            user.displayUserInfo();
        }
    }

    // Helper method to get user by ID
    public User getUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
}
