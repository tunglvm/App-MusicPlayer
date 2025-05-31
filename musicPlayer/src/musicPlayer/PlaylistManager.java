package musicPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Quản lý danh sách Playlist: thêm, sửa, xóa, tìm kiếm, in danh sách.
 */
public class PlaylistManager {
    private final List<Playlist> playlists;

    public PlaylistManager() {
        playlists = new ArrayList<>();
    }

    /**
     * Thêm playlist mới vào danh sách.
     */
    public void addPlaylist(Playlist playlist) {
        if (playlist != null) {
            playlists.add(playlist);
        }
    }

    /**
     * Lấy playlist theo ID.
     */
    public Playlist getPlaylistByID(String playlistID) {
        if (playlistID == null)
            return null;
        for (Playlist pl : playlists) {
            if (playlistID.equals(pl.getPlaylistID())) {
                return pl;
            }
        }
        return null;
    }

    /**
     * Sửa tên playlist theo ID.
     */
    public boolean editPlaylistName(String playlistID, String newName) {
        Playlist pl = getPlaylistByID(playlistID);
        if (pl != null && newName != null && !newName.isEmpty()) {
            pl.setPlaylistName(newName);
            return true;
        }
        return false;
    }

    /**
     * Sửa số bài hát và thời lượng của playlist theo ID.
     */
    public boolean updatePlaylistStats(String playlistID, int numSongs, int playlistDuration) {
        Playlist pl = getPlaylistByID(playlistID);
        if (pl != null) {
            pl.setNumSongs(numSongs);
            pl.setPlaylistDuration(playlistDuration);
            return true;
        }
        return false;
    }

    /**
     * Xóa playlist theo ID.
     */
    public boolean deletePlaylist(String playlistID) {
        return playlists.removeIf(pl -> playlistID != null && playlistID.equals(pl.getPlaylistID()));
    }

    /**
     * In danh sách tất cả playlist.
     */
    public void printPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists found.");
            return;
        }
        for (Playlist pl : playlists) {
            System.out.println(pl);
        }
    }

    /**
     * Lấy toàn bộ danh sách playlist (nếu cần dùng ngoài class).
     */
    public List<Playlist> getAllPlaylists() {
        return new ArrayList<>(playlists);
    }
}
