package musicPlayer.Test.OperationTest;

import Operation.PlayingSongs;
import musicPlayer.Playlist;
import musicPlayer.Album;
import musicPlayer.Songs;

import java.util.ArrayList;
import java.util.List;

public class TestPlayingSongs {
    public static void main(String[] args) {
        // Tạo danh sách bài hát mẫu
        Songs song1 = new Songs("S001");
        song1.setSongInfo("Song A", "Pop", 200, "Artist A");
        Songs song2 = new Songs("S002");
        song2.setSongInfo("Song B", "Ballad", 180, "Artist B");
        Songs song3 = new Songs("S003");
        song3.setSongInfo("Song C", "Rock", 210, "Artist C");

        List<Songs> songList = new ArrayList<>();
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        // Tạo Playlist và Album
        Playlist playlist = new Playlist("My Playlist", "PL001", songList);
        Album album = new Album(
                "ALB001", // albumID
                "My Album", // title
                "Artist A", // artistName
                new ArrayList<>(songList), // songs
                "Test Publisher", // publisher
                590 // duration (tổng thời lượng, ví dụ)
        );

        // Test các chức năng
        PlayingSongs player = new PlayingSongs();

        // Gọi hàm của sinh viên A: In danh sách bài hát trong album
        System.out.println("=== Danh sách bài hát trong Album ===");
        album.printSongList();

        // Gọi hàm của sinh viên C: Phát toàn bộ album (tự động gọi hàm phát từng bài
        // hát của sinh viên B)
        System.out.println("\n=== Test phát toàn bộ Album ===");
        player.playAllFromAlbum(album);

        // Gọi hàm phát playlist (nếu muốn test thêm)
        System.out.println("\n=== Test phát Playlist ===");
        player.playFromPlaylist(playlist);
    }
}