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
        try {
            if (album != null) {
                albums.add(album);
                return true;
            }
            System.out.println("Album không hợp lệ.");
            return false;
        } catch (Exception e) {
            System.out.println("Lỗi trong addAlbum: " + e.getMessage());
            return false;
        }
    }

    /**
     * Sửa tiêu đề album theo ID.
     */
    public boolean editAlbum(String newTitle, String albumID) {
        try {
            for (Album album : albums) {
                if (album.getAlbumID().equals(albumID)) {
                    album.setAlbumTitle(newTitle);
                    return true;
                }
            }
            System.out.println("Không tìm thấy album với ID: " + albumID);
            return false;
        } catch (Exception e) {
            System.out.println("Lỗi trong editAlbum: " + e.getMessage());
            return false;
        }
    }

    /**
     * Xóa album theo ID.
     */
    public boolean deleteAlbum(String albumID) {
        try {
            boolean removed = albums.removeIf(album -> album.getAlbumID().equals(albumID));
            if (!removed) {
                System.out.println("Không tìm thấy album để xóa với ID: " + albumID);
            }
            return removed;
        } catch (Exception e) {
            System.out.println("Lỗi trong deleteAlbum: " + e.getMessage());
            return false;
        }
    }

    /**
     * In danh sách album.
     */
    public void printAlbumList() {
        try {
            if (albums.isEmpty()) {
                System.out.println("No albums found.");
                return;
            }
            for (Album album : albums) {
                System.out.println("Album ID: " + album.getAlbumID() + " Title: " + album.getAlbumTitle());
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong printAlbumList: " + e.getMessage());
        }
    }

    /**
     * Lấy toàn bộ danh sách album (nếu cần dùng ngoài class).
     */
    public List<Album> getAlbums() {
        try {
            return new ArrayList<>(albums);
        } catch (Exception e) {
            System.out.println("Lỗi trong getAlbums: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
