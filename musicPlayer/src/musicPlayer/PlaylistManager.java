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
        try {
            if (playlist != null) {
                playlists.add(playlist);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong addPlaylist: " + e.getMessage());
        }
    }

    /**
     * Lấy playlist theo ID.
     */
    public Playlist getPlaylistByID(String playlistID) {
        try {
            if (playlistID == null) return null;
            for (Playlist pl : playlists) {
                if (playlistID.equals(pl.getPlaylistID())) {
                    return pl;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong getPlaylistByID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Sửa tên playlist theo ID.
     */
    public boolean editPlaylistName(String playlistID, String newName) {
        try {
            Playlist pl = getPlaylistByID(playlistID);
            if (pl != null && newName != null && !newName.isEmpty()) {
                pl.setPlaylistName(newName);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong editPlaylistName: " + e.getMessage());
        }
        return false;
    }

    /**
     * Sửa số bài hát và thời lượng của playlist theo ID.
     */
    public boolean updatePlaylistStats(String playlistID, int numSongs, int playlistDuration) {
        try {
            Playlist pl = getPlaylistByID(playlistID);
            if (pl != null) {
                pl.setNumSongs(numSongs);
                pl.setPlaylistDuration(playlistDuration);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong updatePlaylistStats: " + e.getMessage());
        }
        return false;
    }

    /**
     * Xóa playlist theo ID.
     */
    public boolean deletePlaylist(String playlistID) {
        try {
            return playlists.removeIf(pl -> playlistID != null && playlistID.equals(pl.getPlaylistID()));
        } catch (Exception e) {
            System.out.println("Lỗi trong deletePlaylist: " + e.getMessage());
        }
        return false;
    }

    /**
     * In danh sách tất cả playlist.
     */
    public void printPlaylists() {
        try {
            if (playlists.isEmpty()) {
                System.out.println("No playlists found.");
                return;
            }
            for (Playlist pl : playlists) {
                System.out.println(pl);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong printPlaylists: " + e.getMessage());
        }
    }

    /**
     * Lấy toàn bộ danh sách playlist (nếu cần dùng ngoài class).
     */
    public List<Playlist> getAllPlaylists() {
        try {
            return new ArrayList<>(playlists);
        } catch (Exception e) {
            System.out.println("Lỗi trong getAllPlaylists: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
