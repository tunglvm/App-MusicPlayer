import java.util.ArrayList;
import java.util.Scanner;

public class TestArtistList {
    ArrayList<Artist> al = new ArrayList<Artist>();

    public ArrayList<Artist> addList() {
        Artist a1 = new Artist("A001", "IU");
        Artist a2 = new Artist("A002", "Sơn Tùng");
        Artist a3 = new Artist("A003", "Jack");
        al.add(a1);
        al.add(a2);
        al.add(a3);
        return al;
    }

    public void testEditDelete() {
        ArtistList artistList = new ArtistList();
        ArrayList<Artist> artists = addList();
        for (Artist a : artists) {
            artistList.addArtist(a);
        }

        artistList.printArtistList();

        // Dùng 1 Scanner duy nhất
        Scanner scanner = new Scanner(System.in);

        // Cập nhật thông tin nghệ sĩ
        System.out.println("Enter artist ID to edit:");
        String artistID = scanner.nextLine();

        System.out.println("Enter new artist name:");
        String newName = scanner.nextLine();

        artistList.editArtist(newName, artistID);
        System.out.println("Danh sách nghệ sĩ sau khi sửa:");
        artistList.printArtistList();

        // Xóa nghệ sĩ
        System.out.println("Enter artist ID to delete:");
        String delID = scanner.nextLine();

        artistList.deleteArtist(delID);
        System.out.println("Danh sách nghệ sĩ sau khi xóa:");
        artistList.printArtistList();

        // Đóng scanner ở cuối chương trình
        scanner.close();
    }

    public void testDelete(ArtistList artistList, String artistID) {
        artistList.deleteArtist(artistID);
        artistList.printArtistList();
    }

    public static void main(String[] args) {
        TestArtistList test = new TestArtistList();
        test.testEditDelete();
    }
}
