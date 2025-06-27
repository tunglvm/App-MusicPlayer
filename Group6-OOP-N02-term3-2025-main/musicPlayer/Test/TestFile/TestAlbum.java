package musicPlayer.Test.TestFile;

public class TestAlbum {
    public static void main(String[] args) {
        testAlbumList();
        getAlbumName();
        getAlbumInfo();
    }

    // Kiểm thử hiển thị danh sách album mẫu
    public static void testAlbumList() {
        System.out.println("Album list:");
        System.out.println("1. Album A");
        System.out.println("2. Album B");
        System.out.println("3. Album C");
        System.out.println("4. Album D");
        System.out.println("5. Album E");
    }

    // Kiểm thử lấy tên album
    public static void getAlbumName() {
        System.out.println("Album names:");
        System.out.println("Album A");
        System.out.println("Album B");
        System.out.println("Album C");
        System.out.println("Album D");
        System.out.println("Album E");
    }

    // Kiểm thử lấy thông tin album
    public static void getAlbumInfo() {
        System.out
                .println("Album ID: ALB001, Title: Album A, Artist: Artist A, Publisher: Publisher A, Duration: 3000s");
        System.out
                .println("Album ID: ALB002, Title: Album B, Artist: Artist B, Publisher: Publisher B, Duration: 2500s");
    }
}