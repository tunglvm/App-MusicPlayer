package musicPlayer.Test.TestFile;

import musicPlayer.Album;
import musicPlayer.AlbumList;
import musicPlayer.Songs;
import java.util.ArrayList;

public class TestAlbumList {
    public static void main(String[] args) {
        AlbumList albumList = new AlbumList();

        // Tạo danh sách bài hát mẫu cho album
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("S001"));
        songs.add(new Songs("S002"));

        Album album1 = new Album("ALB001", "A Flower Bookmark", "IU", songs, "Loen Entertainment", 1502);
        Album album2 = new Album("ALB002", "Palette", "IU", songs, "Loen Entertainment", 1800);

        albumList.addAlbum(album1);
        albumList.addAlbum(album2);

        System.out.println("Danh sách album ban đầu:");
        albumList.printAlbumList();

        albumList.editAlbum("Palette Deluxe", "ALB002");

        System.out.println("\nSau khi chỉnh sửa:");
        albumList.printAlbumList();

        albumList.deleteAlbum("ALB001");

        System.out.println("\nSau khi xóa album ALB001:");
        albumList.printAlbumList();
    }
}
