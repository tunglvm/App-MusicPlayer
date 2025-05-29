package musicPlayer.test;
import java.util.ArrayList;
import java.util.Scanner;

import musicPlayer.Album;
import musicPlayer.AlbumList;
import musicPlayer.Artist;
import musicPlayer.Songs;

public class TestAlbumList {
    ArrayList<Album> al = new ArrayList<Album>();

    public ArrayList<Album> addList() {
        // Tạo nghệ sĩ mẫu
        Artist artist = new Artist("ATS001", "IU");

        // Tạo danh sách bài hát mẫu
        Songs song1 = new Songs("IUAFB001");
        song1.setSongInfo("Autumn morning", "K-pop", 218);
        Songs song2 = new Songs("IUAFB002");
        song2.setSongInfo("Secret Garden", "K-pop", 224);
        ArrayList<Songs> albumSongs = new ArrayList<>();
        albumSongs.add(song1);
        albumSongs.add(song2);

        Album a1 = new Album("Album 1", "ALB001", artist, albumSongs, "Copyright 2024", 1200);
        Album a2 = new Album("Album 2", "ALB002", artist, albumSongs, "Copyright 2025", 1300);
        Album a3 = new Album("Album 3", "ALB003", artist, albumSongs, "Copyright 2026", 1400);

        al.add(a1);
        al.add(a2);
        al.add(a3);

        return al;
    }

    public void testEditDelete() {
        AlbumList albumList = new AlbumList();
        ArrayList<Album> albums = addList();
        for (Album a : albums) {
            albumList.addAlbum(a);
        }

        albumList.printAlbumList();

        // Dùng 1 Scanner duy nhất
        Scanner scanner = new Scanner(System.in);

        // Cập nhật thông tin album
        System.out.println("Enter album ID to edit:");
        String albumID = scanner.nextLine();

        System.out.println("Enter new album title:");
        String newTitle = scanner.nextLine();

        albumList.editAlbum(newTitle, albumID);
        System.out.println("Danh sách album sau khi sửa:");
        albumList.printAlbumList();

        // Xóa album
        System.out.println("Enter album ID to delete:");
        String delID = scanner.nextLine();

        albumList.deleteAlbum(delID);
        System.out.println("Danh sách album sau khi xóa:");
        albumList.printAlbumList();

        // Đóng scanner ở cuối chương trình
        scanner.close();
    }

    public void testDelete(AlbumList albumList, String albumID) {
        albumList.deleteAlbum(albumID);
        albumList.printAlbumList();
    }

    public static void main(String[] args) {
        TestAlbumList test = new TestAlbumList();
        test.testEditDelete();
    }
}