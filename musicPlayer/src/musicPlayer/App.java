package musicPlayer;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        // === Tạo các bài hát mẫu ===
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

        // === Tạo EP ===
        EP ep1 = new EP("IUEPAFB");
        ep1.setEPInfo("A Flower Bookmark", song1, song2, song3, song4, song5, song6);

        // === Tạo nghệ sĩ ===
        Artist iu = new Artist("ATS001", "IU");
        iu.setArtistInfo("Korean", "16-5-1993");
        iu.setArtistProduct(null, ep1, null);

        // === Tạo user ===
        User user1 = new User(
                "Quốc Huy",
                19,
                "hi@001",
                "hi@gmail.com",
                "0123456789",
                "Hà Nội",
                "2024-05-21");
        user1.displayUserInfo();

        // === In thông tin EP ===
        System.out.println(ep1.getEPInfo());

        // === CRUD cho Album ===
        System.out.println("\n=== Album CRUD ===");
        AlbumList albumList = new AlbumList();
        ArrayList<Songs> albumSongs = new ArrayList<>();
        albumSongs.add(song1);
        albumSongs.add(song2);

        // Nếu class Album có các thuộc tính: title, id, artist, songs, copyright,
        // duration
        Album album1 = new Album("Album 1", "ALB001", iu, albumSongs, "Copyright 2024", 1200);
        albumList.addAlbum(album1);
        Album album2 = new Album("Love Poem", "ALB002", iu, albumSongs, "Copyright 2025", 1300);
        albumList.addAlbum(album2);

        // In danh sách album ban đầu
        System.out.println("\nDanh sách album ban đầu:");
        albumList.printAlbumList();

        // Sửa tiêu đề album
        albumList.editAlbum("Palette", "ALB001");

        // In danh sách album sau khi sửa
        System.out.println("\nDanh sách album sau khi sửa:");
        albumList.printAlbumList();

        // Xóa album
        albumList.deleteAlbum("ALB002");

        // In danh sách album sau khi xóa
        System.out.println("\nDanh sách album sau khi xóa:");
        albumList.printAlbumList();

        // === CRUD cho Artist ===
        System.out.println("\n=== Artist CRUD ===");
        ArtistList artistList = new ArtistList();
        Artist artist1 = new Artist("A001", "IU");
        Artist artist2 = new Artist("A002", "Sơn Tùng");
        Artist artist3 = new Artist("A003", "Jack");

        // Thêm nghệ sĩ
        artistList.addArtist(artist1);
        artistList.addArtist(artist2);
        artistList.addArtist(artist3);

        // In danh sách nghệ sĩ
        System.out.println("\nDanh sách nghệ sĩ ban đầu:");
        artistList.printArtistList();

        // Sửa tên nghệ sĩ
        artistList.editArtist("HIEUTHUHAI", "A003");
        System.out.println("\nSau khi sửa tên nghệ sĩ:");
        artistList.printArtistList();

        // Xóa nghệ sĩ
        artistList.deleteArtist("A003");
        System.out.println("\nSau khi xoá nghệ sĩ A003:");
        artistList.printArtistList();

        // === CRUD cho Playlist ===
        System.out.println("\n=== Playlist CRUD ===");
        PlaylistManager playlistManager = new PlaylistManager();

        Playlist playlist1 = new Playlist("Chill IU", "PL001", 6, 1402);
        Playlist playlist2 = new Playlist("Rainy Vibes", "PL002", 2, 490);

        // Thêm playlist
        playlistManager.addPlaylist(playlist1);
        playlistManager.addPlaylist(playlist2);

        // In danh sách ban đầu
        System.out.println("Danh sách playlist ban đầu:");
        playlistManager.printPlaylists();

        // Sửa tên playlist
        playlistManager.editPlaylistName("PL001", "IU Chill Hits");

        // Cập nhật số bài hát và thời lượng
        playlistManager.updatePlaylistStats("PL001", 6, 1500);

        // In sau khi chỉnh sửa
        System.out.println("\nSau khi chỉnh sửa:");
        playlistManager.printPlaylists();

        // Xóa một playlist
        playlistManager.deletePlaylist("PL002");

        // In sau khi xóa
        System.out.println("\nSau khi xoá playlist PL002:");
        playlistManager.printPlaylists();
    }
}
