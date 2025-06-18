package musicPlayer;

import java.util.List;

public class Playlist {
    private String playlistName;
    private String playlistID;
    private int numSongs;
    private int playlistDuration; // đơn vị: giây
    private List<Songs> songs; // Thêm thuộc tính này

    public Playlist(String playlistName, String playlistID, int numSongs, int playlistDuration) {
        try {
            this.playlistName = playlistName;
            this.playlistID = playlistID;
            this.numSongs = numSongs;
            this.playlistDuration = playlistDuration;
        } catch (Exception e) {
            System.out.println("Lỗi trong Playlist Constructor: " + e.getMessage());
        }
    }

    // Thêm constructor nếu muốn truyền vào danh sách bài hát
    public Playlist(String playlistName, String playlistID, List<Songs> songs) {
        try {
            this.playlistName = playlistName;
            this.playlistID = playlistID;
            this.songs = songs;
            this.numSongs = (songs != null) ? songs.size() : 0;
            this.playlistDuration = 0; // Có thể tính tổng thời lượng nếu muốn
        } catch (Exception e) {
            System.out.println("Lỗi trong Playlist Constructor (List): " + e.getMessage());
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        try {
            this.playlistName = playlistName;
        } catch (Exception e) {
            System.out.println("Lỗi trong setPlaylistName: " + e.getMessage());
        }
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void setNumSongs(int numSongs) {
        try {
            this.numSongs = numSongs;
        } catch (Exception e) {
            System.out.println("Lỗi trong setNumSongs: " + e.getMessage());
        }
    }

    public int getPlaylistDuration() {
        return playlistDuration;
    }

    public void setPlaylistDuration(int playlistDuration) {
        try {
            this.playlistDuration = playlistDuration;
        } catch (Exception e) {
            System.out.println("Lỗi trong setPlaylistDuration: " + e.getMessage());
        }
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        try {
            this.songs = songs;
            this.numSongs = (songs != null) ? songs.size() : 0;
        } catch (Exception e) {
            System.out.println("Lỗi trong setSongs: " + e.getMessage());
        }
    }

    // Hàm để in danh sách bài hát trong Playlist
    /**
     * In danh sách bài hát trong Playlist.
     */
    public void printSongList() {
        try {
            if (songs == null || songs.isEmpty()) {
                System.out.println("Playlist không có bài hát nào.");
                return;
            }
            System.out.println("Danh sách bài hát trong playlist \"" + playlistName + "\":");
            for (Songs song : songs) {
                System.out.println("- " + song.getTitle() + " (" + song.getArtist() + ")");
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong printSongList: " + e.getMessage());
        }
    }

    public String toString() {
        try {
            return "Playlist: " + playlistName +
                    " (ID: " + playlistID + "), " +
                    numSongs + " bài hát, " +
                    playlistDuration + " giây";
        } catch (Exception e) {
            System.out.println("Lỗi trong toString: " + e.getMessage());
            return null;
        }
    }
}
