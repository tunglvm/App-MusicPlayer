package musicPlayer.Test.TestFile;

public class testSong {
    public static void main(String[] args) {
        testSongList();
        getSongName();
        getSongInfo();
    }

    // Kiểm thử hiển thị danh sách bài hát mẫu
    public static void testSongList() {
        System.out.println("Song list:");
        System.out.println("1. Lullaby");
        System.out.println("2. unlucky");
    }

    // Kiểm thử lấy tên bài hát
    public static void getSongName() {
        System.out.println("Song names:");
        System.out.println("Lullaby");
        System.out.println("unlucky");
    }

    // Kiểm thử lấy thông tin bài hát
    public static void getSongInfo() {
        System.out.println("Song Title: Lullaby");
        System.out.println("Song ID: 1");
        System.out.println("Artist: IU");
        System.out.println("Album: Album A");
        System.out.println("Copyright: 2023");
        System.out.println("Duration: 300 seconds");
    }
}
