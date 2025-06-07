package musicPlayer;

import java.util.ArrayList;

public class UserList {
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> addUser(User user) {
        users.add(user);
        return users;
    }

    public ArrayList<User> editUser(String newName, String userID) {
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
            System.out.println("User ID: " + user.getUserID() + " Name: " + user.getName());
        }
    }
}
