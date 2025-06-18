package musicPlayer;

import java.util.ArrayList;

public class SongsList {
    ArrayList<Songs> songs = new ArrayList<>();

    public ArrayList<Songs> addSong(Songs song) {
        try {
            songs.add(song);
            return songs;
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm bài hát: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    public ArrayList<Songs> editSong(String newTitle, String songID) {
        try {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getSongID().equals(songID)) {
                    songs.get(i).setSongTitle(newTitle);
                }
            }
            return songs;
        } catch (Exception e) {
            System.out.println("Lỗi khi sửa bài hát: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    public ArrayList<Songs> deleteSong(String songID) {
        try {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getSongID().equals(songID)) {
                    songs.remove(i);
                    break;
                }
            }
            return songs;
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa bài hát: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    public void printSongsList() {
        try {
            for (Songs song : songs) {
                System.out.println("Song ID: " + song.getSongID() + " Title: " + song.getSongTitle());
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi in danh sách bài hát: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }
}

