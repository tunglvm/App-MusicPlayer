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
        boolean result = false;
        try {
            if (album != null) {
                albums.add(album);
                result = true;
            } else {
                System.out.println("Album không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong addAlbum: " + e.getMessage());
        } finally {
            // Có thể log hoặc cleanup nếu cần
        }
        return result;
    }

    /**
     * Sửa tiêu đề album theo ID.
     */
    public boolean editAlbum(String newTitle, String albumID) {
        boolean result = false;
        try {
            for (Album album : albums) {
                if (album.getAlbumID().equals(albumID)) {
                    album.setAlbumTitle(newTitle);
                    result = true;
                    break;
                }
            }
            if (!result) {
                System.out.println("Không tìm thấy album với ID: " + albumID);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong editAlbum: " + e.getMessage());
        } finally {
            // Có thể log hoặc cleanup nếu cần
        }
        return result;
    }

    /**
     * Xóa album theo ID.
     */
    public boolean deleteAlbum(String albumID) {
        boolean removed = false;
        try {
            removed = albums.removeIf(album -> album.getAlbumID().equals(albumID));
            if (!removed) {
                System.out.println("Không tìm thấy album để xóa với ID: " + albumID);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong deleteAlbum: " + e.getMessage());
        } finally {
            // Có thể log hoặc cleanup nếu cần
        }
        return removed;
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
        } finally {
            // Có thể log hoặc cleanup nếu cần
        }
    }

    /**
     * Lấy toàn bộ danh sách album (nếu cần dùng ngoài class).
     */
    public List<Album> getAlbums() {
        List<Album> result = new ArrayList<>();
        try {
            result = new ArrayList<>(albums);
        } catch (Exception e) {
            System.out.println("Lỗi trong getAlbums: " + e.getMessage());
        } finally {
            // Có thể log hoặc cleanup nếu cần
        }
        return result;
    }
}