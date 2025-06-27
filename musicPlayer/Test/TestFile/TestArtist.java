package musicPlayer.Test.TestFile;

public class TestArtist {
    public static void main(String[] args) {
        test();
        getArtistName();
        getArtistInfo();
    }

    // Kiểm thử hiển thị danh sách nghệ sĩ mẫu
    public static void test() {
        System.out.println("Artist list: ");
        System.out.println("1. Artist A");
        System.out.println("2. Artist B");
        System.out.println("3. Artist C");
        System.out.println("4. Artist D");
        System.out.println("5. Artist E");
    }

    // Kiểm thử lấy tên nghệ sĩ
    public static void getArtistName() {
        System.out.println("Artist names:");
        System.out.println("Artist A");
        System.out.println("Artist B");
        System.out.println("Artist C");
        System.out.println("Artist D");
        System.out.println("Artist E");
    }

    // Kiểm thử lấy thông tin nghệ sĩ
    public static void getArtistInfo() {
        System.out.println("Artist ID: 1, Name: HIEUTHUHAI, Nationality: Vietnamese, Birthdate: 1990-01-01");
        System.out.println("Artist ID: 2, Name: IU, Nationality: Korean, Birthdate: 1993-05-16");  
    }
}
