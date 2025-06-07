package musicPlayer.Test.TestFile;

public class TestPlaylist {
    public static void main(String[] args) {
        testPlaylistList();
        getPlaylistName();
        getPlaylistInfo();
    }

    // Kiểm thử hiển thị danh sách playlist mẫu
    public static void testPlaylistList() {
        System.out.println("Playlist list:");
        System.out.println("1. Chill Hits");
        System.out.println("2. Kpop Vibes");
        System.out.println("3. Ballad Mood");
    }

    // Kiểm thử lấy tên playlist
    public static void getPlaylistName() {
        System.out.println("Playlist names:");
        System.out.println("Chill Hits");
        System.out.println("Kpop Vibes");
        System.out.println("Ballad Mood");
    }

    // Kiểm thử lấy thông tin playlist
    public static void getPlaylistInfo() {
        System.out.println("Playlist ID: PL001, Name: Chill Hits, Songs: 10, Duration: 3200s");
        System.out.println("Playlist ID: PL002, Name: Kpop Vibes, Songs: 8, Duration: 2500s");
    }
}
