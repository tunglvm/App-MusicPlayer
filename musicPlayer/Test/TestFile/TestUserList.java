package musicPlayer.Test.TestFile;

import java.util.ArrayList;
import java.util.Scanner;
import musicPlayer.User;
import musicPlayer.UserList;

public class TestUserList {
    ArrayList<User> ul = new ArrayList<User>();

    public ArrayList<User> addList() {
        User u1 = new User("U001", "User A");
        User u2 = new User("U002", "User B");
        User u3 = new User("U003", "User C");
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

        // Cập nhật thông tin user
        System.out.println("Enter user ID to edit:");
        String userID = scanner.nextLine();

        System.out.println("Enter new user name:");
        String newName = scanner.nextLine();

        userList.editUser(newName, userID);
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

    public static void main(String[] args) {
        TestUserList test = new TestUserList();
        test.testEditDelete();
    }
}
