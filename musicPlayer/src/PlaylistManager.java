
import java.util.ArrayList;

public class PlaylistManager {
    private ArrayList<Playlist> playlists;

    public PlaylistManager() {
        playlists = new ArrayList<>();
    }

    // Create: thêm playlist mới
    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    // Read: lấy playlist theo ID
    public Playlist getPlaylistByID(String playlistID) {
        for (Playlist pl : playlists) {
            if (pl.getPlaylistID().equals(playlistID)) {
                return pl;
            }
        }
        return null;
    }

    // Update: sửa tên playlist
    public boolean editPlaylistName(String playlistID, String newName) {
        Playlist pl = getPlaylistByID(playlistID);
        if (pl != null) {
            pl.setPlaylistName(newName);
            return true;
        }
        return false;
    }

    // Update: sửa số bài và thời lượng (giả sử bạn tự tính ra và cập nhật)
    public boolean updatePlaylistStats(String playlistID, int numSongs, int playlistDuration) {
        Playlist pl = getPlaylistByID(playlistID);
        if (pl != null) {
            pl.setNumSongs(numSongs);
            pl.setPlaylistDuration(playlistDuration);
            return true;
        }
        return false;
    }

    // Delete: xóa playlist theo ID
    public boolean deletePlaylist(String playlistID) {
        return playlists.removeIf(pl -> pl.getPlaylistID().equals(playlistID));
    }

    // In danh sách playlist
    public void printPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists found.");
            return;
        }
        for (Playlist pl : playlists) {
            System.out.println(pl);
        }
    }
}
