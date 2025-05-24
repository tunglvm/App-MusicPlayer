import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        // Tạo các bài hát
        Songs song1 = new Songs("IUAFB001");
        Songs song2 = new Songs("IUAFB002");
        Songs song3 = new Songs("IUAFB003");
        Songs song4 = new Songs("IUAFB004");
        Songs song5 = new Songs("IUAFB005");
        Songs song6 = new Songs("IUAFB006");

        song1.setSongInfo("Autumn morning", "K-pop", 218);
        song2.setSongInfo("Secret Garden", "K-pop", 224);
        song3.setSongInfo("Sleepless rainy night", "K-pop", 266);
        song4.setSongInfo("Last night story", "K-pop", 233);
        song5.setSongInfo("By the stream", "K-pop", 337);
        song6.setSongInfo("Everyday with you", "K-pop", 224);

        // Tạo EP
        EP EP1 = new EP("IUEPAFB");
        EP1.setEPInfo("A Flower Bookmark", song1, song2, song3, song4, song5, song6);

        // Tạo nghệ sĩ
        Artist IU = new Artist("ATS001", "IU");
        IU.setArtistInfo("Korean", "16-5-1993");
        IU.setArtistProduct(null, EP1, null);

        // Tạo user
        User user1 = new User(
                "Quốc Huy",
                19,
                "hi@001",
                "hi@gmail.com",
                "0123456789",
                "Hà Nội",
                "2024-05-21");
        user1.displayUserInfo();

        // In thông tin EP
        System.out.println(EP1.getEPInfo());

        // CRUD cho Album
        AlbumList manager = new AlbumList();
        ArrayList<Songs> albumSongs = new ArrayList<>();
        albumSongs.add(song1);
        albumSongs.add(song2);
        // ... thêm các bài hát khác nếu muốn

        Album album1 = new Album("Album 1", "ALB001", IU, albumSongs, "Copyright 2024", 1200);
        manager.addAlbum(album1); // Thêm album

        manager.printAlbumList(); // In danh sách album

        // Sửa tiêu đề album
        manager.editAlbum("New Title", "ALB001");
        manager.printAlbumList();

        // Xóa album
        manager.deleteAlbum("ALB001");
        manager.printAlbumList();
    }
}
