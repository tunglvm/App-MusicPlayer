package musicPlayer.Test.TestFile;

public class TestUser {
    public static void main(String[] args) {
        test();
        getUserName();
        getUserInfo();
    }

    // Kiểm thử hiển thị danh sách người dùng mẫu
    public static void test() {
        System.out.println("User list: ");
        System.out.println("1. User A");
        System.out.println("2. User B");
        System.out.println("3. User C");
        System.out.println("4. User D");
        System.out.println("5. User E");
    }

    // Kiểm thử lấy tên người dùng
    public static void getUserName() {
        System.out.println("User names:");
        System.out.println("User A");
        System.out.println("User B");
        System.out.println("User C");
        System.out.println("User D");
        System.out.println("User E");
    }

    // Kiểm thử lấy thông tin người dùng
    public static void getUserInfo() {
        System.out.println("User information:");
        System.out.println("User ID: 1, Name: Quốc Huy, Email: quochuy@gmail.com, Phone: 0123456789");
        System.out.println("User ID: 2, Name: Tùng Lâm, Email: tunglam@gmail.com, Phone: 0987654321");
        System.out.println("User ID: 3, Name: Quỳnh Chi, Email: quynhchi@gmail.com, Phone: 0912345678");
    }
}