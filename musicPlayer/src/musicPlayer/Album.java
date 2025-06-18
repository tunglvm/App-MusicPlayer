package musicPlayer;

import java.util.ArrayList;

public class Album {
    private String albumID;
    private String title;
    private String artistName;
    private ArrayList<Songs> songs;
    private String publisher;
    private int duration;

    public Album(String albumID, String title, String artistName, ArrayList<Songs> songs, String publisher, int duration) {
        try {
            this.albumID = albumID;
            this.title = title;
            this.artistName = artistName;
            this.songs = songs;
            this.publisher = publisher;
            this.duration = duration;
        } catch (Exception e) {
            System.out.println("Lỗi trong constructor Album: " + e.getMessage());
        } finally {
            System.out.println("Khởi tạo Album hoàn tất (có thể thành công hoặc có lỗi).");
        }
    }

    public String getAlbumID() {
        return albumID;
    }

    public String getAlbumTitle() {
        return title;
    }

    public void setAlbumTitle(String newTitle) {
        try {
            this.title = newTitle;
        } catch (Exception e) {
            System.out.println("Lỗi trong setAlbumTitle: " + e.getMessage());
        } finally {
            System.out.println("Kết thúc phương thức setAlbumTitle.");
        }
    }

    public String getAlbumInfo() {
        try {
            return "Album ID: " + albumID +
                    ", Title: " + title +
                    ", Artist: " + artistName +
                    ", Publisher: " + publisher +
                    ", Duration: " + duration + "s";
        } catch (Exception e) {
            System.out.println("Lỗi trong getAlbumInfo: " + e.getMessage());
            return null;
        } finally {
            System.out.println("Kết thúc phương thức getAlbumInfo.");
        }
    }

    public ArrayList<Songs> getSongs() {
        return songs;
    }

    public void printSongList() {
        try {
            if (songs == null || songs.isEmpty()) {
                System.out.println("Album không có bài hát nào.");
                return;
            }
            System.out.println("Danh sách bài hát trong album \"" + title + "\":");
            for (Songs song : songs) {
                System.out.println("- " + song.getTitle() + " (" + song.getArtist() + ")");
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong printSongList: " + e.getMessage());
        } finally {
            System.out.println("Kết thúc phương thức printSongList.");
        }
    }

    public void playAllFromAlbum() {
        try {
            if (songs == null || songs.isEmpty()) {
                System.out.println("Album không có bài hát nào để phát.");
                return;
            }
            System.out.println("Đang phát tất cả bài hát trong album: " + title);
            for (Songs song : songs) {
                System.out.println("Đang phát: " + song.getTitle() + " - " + song.getArtist());
            }
            System.out.println("Phát xong tất cả bài hát trong album: " + title);
        } catch (Exception e) {
            System.out.println("Lỗi trong playAllFromAlbum: " + e.getMessage());
        } finally {
            System.out.println("Kết thúc phương thức playAllFromAlbum.");
        }
    }
}
