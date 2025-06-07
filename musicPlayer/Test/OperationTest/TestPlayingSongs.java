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

        // Test PlayingSongs
        PlayingSongs player = new PlayingSongs();

        System.out.println("=== Test phát Playlist ===");
        player.playFromPlaylist(playlist);

        System.out.println("\n=== Test phát Album ===");
        player.playFromAlbum(album);
    }
}