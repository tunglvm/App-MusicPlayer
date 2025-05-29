package musicPlayer.test;
import java.util.ArrayList;
import musicPlayer.User;
import musicPlayer.UserList;


public class TestUserList {
    public static void main(String[] args) {
        UserList userList = new UserList();

        // Thêm user (Create)
        userList.addUser(new User("Quốc Huy", 19, "hi@001", "hi@gmail.com", "0123456789", "Hà Nội", "2024-05-21"));
        userList.addUser(new User("Tùng Lâm", 19, "lvm@002", "lvm@gmail.com", "0987654321", "Hà Nội", "2024-05-22"));
        userList.addUser(new User("Quỳnh Chi", 19, "chie@003", "chie@gmail.com", "0111222333", "Hà Nội", "2024-05-23"));

        // Đọc danh sách user (Read)
        System.out.println("== Danh sách user ban đầu ==");
        userList.printUserList();

        // Sửa tên user (Update)
        boolean update = userList.editUserName("hi@001", "Huy Trần");
        System.out.println("\n== Sau khi sửa tên user hi@001 ==");
        userList.printUserList();

        // Xóa user (Delete)
        boolean delete = userList.deleteUser("lvm@002");
        System.out.println("\n== Sau khi xóa user lvm@002 ==");
        userList.printUserList();
    }
}
