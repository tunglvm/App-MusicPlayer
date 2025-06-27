package musicPlayer;

public class Song {
    private String name;
    private String artist;

    // Constructor
    public Song(String name, String artist) {
        try {
            this.name = name;
            this.artist = artist;
            System.out.println("Khởi tạo bài hát thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi khi khởi tạo bài hát: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Getter cho name
    public String getName() {
        try {
            return name;
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy tên bài hát: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Setter cho name
    public void setName(String name) {
        try {
            this.name = name;
            System.out.println("Đã cập nhật tên bài hát!");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật tên bài hát: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Getter cho artist
    public String getArtist() {
        try {
            return artist;
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy tên nghệ sĩ: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Setter cho artist
    public void setArtist(String artist) {
        try {
            this.artist = artist;
            System.out.println("Đã cập nhật tên nghệ sĩ!");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật tên nghệ sĩ: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Phát bài hát
    public void play() {
        try {
            System.out.println("Đang phát: " + name + " - " + artist);
        } catch (Exception e) {
            System.out.println("Lỗi khi phát bài hát: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }

    // Hiển thị thông tin bài hát
    @Override
    public String toString() {
        try {
            return "Bài hát: " + name + " - Nghệ sĩ: " + artist;
        } catch (Exception e) {
            System.out.println("Lỗi khi chuyển bài hát sang chuỗi: " + e.getMessage());
            e.printStackTrace();
            return "";
        } finally {
            // Có thể để trống hoặc thêm code dọn dẹp nếu cần
        }
    }
}

