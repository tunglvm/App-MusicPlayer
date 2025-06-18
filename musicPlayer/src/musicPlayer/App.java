import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import Operation.PlayingSongs;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        // Khởi tạo dữ liệu mẫu cần thiết cho chức năng chính
        Songs song1 = new Songs("IUAFB001");
        Songs song2 = new Songs("IUAFB002");
        Songs song3 = new Songs("IUAFB003");
        Songs song4 = new Songs("IUAFB004");
        Songs song5 = new Songs("IUAFB005");
        Songs song6 = new Songs("IUAFB006");

        song1.setSongInfo("Autumn morning", "K-pop", 218, "IU");
        song2.setSongInfo("Secret Garden", "K-pop", 224, "IU");
        song3.setSongInfo("Sleepless rainy night", "K-pop", 266, "IU");
        song4.setSongInfo("Last night story", "K-pop", 233, "IU");
        song5.setSongInfo("By the stream", "K-pop", 337, "IU");
        song6.setSongInfo("Everyday with you", "K-pop", 224, "IU");

        ArrayList<Songs> albumSongs = new ArrayList<>();
        albumSongs.add(song1);
        albumSongs.add(song2);
        albumSongs.add(song3);
        albumSongs.add(song4);
        albumSongs.add(song5);
        albumSongs.add(song6);

        Album album1 = new Album("ALB001", "A Flower Bookmark", "IU", albumSongs, "Loen Entertainment", 1502);
        Playlist playlist1 = new Playlist("Chill IU", "PL001", albumSongs);

        // Gọi các chức năng chính
        PlayingSongs player = new PlayingSongs();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("\n--- Danh sách bài hát trong album ---");
            album1.printSongList();

            System.out.println("\n--- Danh sách bài hát trong playlist ---");
            playlist1.printSongList();

            System.out.println("\nMenu:");
            System.out.println("1. Phát toàn bộ album");
            System.out.println("2. Phát toàn bộ playlist");
            System.out.println("3. Chọn và phát một bài hát trong album");
            System.out.println("4. Chọn và phát một bài hát trong playlist");
            System.out.println("5. Phát ngẫu nhiên một bài hát trong album");
            System.out.println("6. Phát ngẫu nhiên một bài hát trong playlist");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                player.playAllFromAlbum(album1);
            } else if (choice == 2) {
                player.playFromPlaylist(playlist1);
            } else if (choice == 3) {
                System.out.print("Nhập số thứ tự bài hát trong album (bắt đầu từ 1): ");
                int idx = scanner.nextInt();
                if (idx >= 1 && idx <= albumSongs.size()) {
                    player.playSong(albumSongs.get(idx - 1));
                } else {
                    System.out.println("Số thứ tự không hợp lệ!");
                }
            } else if (choice == 4) {
                System.out.print("Nhập số thứ tự bài hát trong playlist (bắt đầu từ 1): ");
                int idx = scanner.nextInt();
                java.util.List<Songs> playlistSongs = playlist1.getSongs();
                if (idx >= 1 && idx <= playlistSongs.size()) {
                    player.playSong(playlistSongs.get(idx - 1));
                } else {
                    System.out.println("Số thứ tự không hợp lệ!");
                }
            } else if (choice == 5) {
                int idx = random.nextInt(albumSongs.size());
                System.out.println("Phát ngẫu nhiên bài hát trong album:");
                player.playSong(albumSongs.get(idx));
            } else if (choice == 6) {
                java.util.List<Songs> playlistSongs = playlist1.getSongs();
                int idx = random.nextInt(playlistSongs.size());
                System.out.println("Phát ngẫu nhiên bài hát trong playlist:");
                player.playSong(playlistSongs.get(idx));
            } else if (choice == 0) {
                System.out.println("Đã thoát chương trình.");
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        scanner.close();
    }
}
