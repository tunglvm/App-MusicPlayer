package musicPlayer.test;

import java.util.ArrayList;
import java.util.Scanner;

import musicPlayer.User;
import musicPlayer.UserList;

public class TestUserList {
    ArrayList<User> ul = new ArrayList<User>();

    public ArrayList<User> addList() {
        User u1 = new User("Quốc Huy", 19, "hi@001", "hi@gmail.com", "0123456789", "Hà Nội", "2024-05-21");
        User u2 = new User("Tùng Lâm", 19, "lvm@002", "lvm@gmail.com", "0987654321", "Hà Nội", "2024-05-22");
        User u3 = new User("Quỳnh Chi", 19, "chie@003", "chie@gmail.com", "0111222333", "Hà Nội", "2024-05-23");
        ul.add(u1);
        ul.add(u2);
        ul.add(u3);
        return ul;
    }

    public void testEditDelete() {
        UserList userList = new UserList();
        ArrayList<User> users = addList();
        for (User u : users) {
            userList.addUser(u);
        }

        userList.printUserList();

        Scanner scanner = new Scanner(System.in);

        // Cập nhật tên user
        System.out.println("Enter user ID to edit:");
        String userID = scanner.nextLine();

        System.out.println("Enter new user name:");
        String newName = scanner.nextLine();

        userList.editUserName(userID, newName);
        System.out.println("Danh sách user sau khi sửa:");
        userList.printUserList();

        // Xóa user
        System.out.println("Enter user ID to delete:");
        String delID = scanner.nextLine();

        userList.deleteUser(delID);
        System.out.println("Danh sách user sau khi xóa:");
        userList.printUserList();

        scanner.close();
    }

    public void testDelete(UserList userList, String userID) {
        userList.deleteUser(userID);
        userList.printUserList();
    }

    public static void main(String[] args) {
        TestUserList test = new TestUserList();
        test.testEditDelete();
    }
}
