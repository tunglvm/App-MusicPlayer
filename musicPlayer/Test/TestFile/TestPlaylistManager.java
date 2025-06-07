package musicPlayer.Test.TestFile;

import musicPlayer.Playlist;
import musicPlayer.PlaylistManager;

public class TestPlaylistManager {
    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();

        Playlist pl1 = new Playlist("Kpop", "KP001", 34, 7380);
        Playlist pl2 = new Playlist("Chill Hits", "PL002", 8, 2000);

        manager.addPlaylist(pl1);
        manager.addPlaylist(pl2);

        System.out.println("Danh sách playlist ban đầu:");
        manager.printPlaylists();

        manager.editPlaylistName("KP001", "KPOP SONGS");

        manager.updatePlaylistStats("KP001", 40, 9500);

        System.out.println("\nSau khi chỉnh sửa:");
        manager.printPlaylists();

        manager.deletePlaylist("PL002");

        System.out.println("\nSau khi xóa playlist PL002:");
        manager.printPlaylists();
    }
}
