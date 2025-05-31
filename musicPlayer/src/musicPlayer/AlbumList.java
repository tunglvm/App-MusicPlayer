package musicPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Quản lý danh sách Album: thêm, sửa, xóa, in danh sách.
 */
public class AlbumList {
    private final List<Album> albums = new ArrayList<>();

    /**
     * Thêm album mới vào danh sách.
     */
    public boolean addAlbum(Album album) {
        if (album != null) {
            albums.add(album);
            return true;
        }
        return false;
    }

    /**
     * Sửa tiêu đề album theo ID.
     */
    public boolean editAlbum(String newTitle, String albumID) {
        for (Album album : albums) {
            if (album.getAlbumID().equals(albumID)) {
                album.setAlbumTitle(newTitle);
                return true;
            }
        }
        return false;
    }

    /**
     * Xóa album theo ID.
     */
    public boolean deleteAlbum(String albumID) {
        return albums.removeIf(album -> album.getAlbumID().equals(albumID));
    }

    /**
     * In danh sách album.
     */
    public void printAlbumList() {
        if (albums.isEmpty()) {
            System.out.println("No albums found.");
            return;
        }
        for (Album album : albums) {
            System.out.println("Album ID: " + album.getAlbumID() + " Title: " + album.getAlbumTitle());
        }
    }

    /**
     * Lấy toàn bộ danh sách album (nếu cần dùng ngoài class).
     */
    public List<Album> getAlbums() {
        return new ArrayList<>(albums);
    }
}
