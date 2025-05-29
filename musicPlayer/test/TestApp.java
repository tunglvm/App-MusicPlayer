package musicPlayer.test;

import musicPlayer.App;
import musicPlayer.EP;
import musicPlayer.Artist;
import musicPlayer.AlbumList;
import musicPlayer.Songs;
import musicPlayer.Album;
import musicPlayer.Playlist;
import musicPlayer.User;
import java.util.ArrayList;

public class TestApp {

    // CRUD dùng chung cho danh sách Album
    public static void crudAlbums(ArrayList<Album> albums) {
        Album newAlbum = albums.get(0);
        System.out.println("Thêm album: " + newAlbum.getAlbumTitle());

        System.out.println("Danh sách album hiện tại:");
        for (Album a : albums) {
            System.out.println(a.getAlbumInfo());
        }

        if (!albums.isEmpty()) {
            albums.get(0).setAlbumTitle("Album Đã Sửa");
            System.out.println("Đã sửa tên album đầu tiên thành: " + albums.get(0).getAlbumTitle());
        }

        if (!albums.isEmpty()) {
            Album removed = albums.remove(albums.size() - 1);
            System.out.println("Đã xóa album: " + removed.getAlbumTitle());
        }

        System.out.println("Danh sách album sau CRUD:");
        for (Album a : albums) {
            System.out.println(a.getAlbumInfo());
        }
    }

    // CRUD dùng chung cho danh sách Playlist
    public static void crudPlaylists(ArrayList<Playlist> playlists) {
        Playlist newPlaylist = playlists.get(0);
        System.out.println("Thêm playlist: " + newPlaylist.getPlaylistName());

        System.out.println("Danh sách playlist hiện tại:");
        for (Playlist p : playlists) {
            System.out.println(p.getPlaylistName() + " - " + p.getPlaylistID());
        }

        if (!playlists.isEmpty()) {
            playlists.get(0).setPlaylistName("Playlist Đã Sửa");
            System.out.println("Đã sửa tên playlist đầu tiên thành: " + playlists.get(0).getPlaylistName());
        }

        if (!playlists.isEmpty()) {
            Playlist removed = playlists.remove(playlists.size() - 1);
            System.out.println("Đã xóa playlist: " + removed.getPlaylistName());
        }

        System.out.println("Danh sách playlist sau CRUD:");
        for (Playlist p : playlists) {
            System.out.println(p.getPlaylistName() + " - " + p.getPlaylistID());
        }
    }

    // CRUD dùng chung cho danh sách User
    public static void crudUsers(ArrayList<User> users) {
        System.out.println("== CRUD User ==");

        // Read
        System.out.println("Danh sách user hiện tại:");
        for (User u : users) {
            u.displayUserInfo();
        }

        // Update
        if (!users.isEmpty()) {
            users.get(0).setName("User Đã Sửa");
            System.out.println("Đã sửa tên user đầu tiên thành: " + users.get(0).getName());
        }

        // Delete
        if (!users.isEmpty()) {
            User removed = users.remove(users.size() - 1);
            System.out.println("Đã xóa user: " + removed.getName());
        }

        // Read lại
        System.out.println("Danh sách user sau CRUD:");
        for (User u : users) {
            u.displayUserInfo();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        EP ep = app.createSampleEP();
        Artist artist = app.createSampleArtist(ep);

        // In thông tin EP
        System.out.println(ep.getEPInfo());

        // Lấy 2 bài hát đầu tiên từ EP để tạo album list
        Songs song1 = ep.getSongs().get(0);
        Songs song2 = ep.getSongs().get(1);

        // Tạo và in album list
        AlbumList albumList = app.createSampleAlbumList(artist, song1, song2);
        System.out.println("\nDanh sách album ban đầu:");
        albumList.printAlbumList();

        // Tạo danh sách album với n đối tượng
        ArrayList<Album> albums = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            ArrayList<Songs> albumSongs = new ArrayList<>();
            albumSongs.add(song1);
            albumSongs.add(song2);
            albums.add(new Album("Album " + i, "ALB00" + i, artist, albumSongs, "Copyright " + (2020 + i), 1000 + i));
        }

        // Gọi CRUD cho n đối tượng Album
        crudAlbums(albums);

        // Tạo danh sách playlist với n đối tượng
        ArrayList<Playlist> playlists = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            playlists.add(new Playlist("Playlist " + i, "PL00" + i, 2, 400 + i * 100));
        }

        // Gọi CRUD cho n đối tượng Playlist
        crudPlaylists(playlists);

        // Tạo danh sách user với n đối tượng
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Quốc Huy", 19, "hi@001", "hi@gmail.com", "0123456789", "Hà Nội", "2024-05-21"));
        users.add(new User("Minh Tuấn", 20, "mt@002", "mt@gmail.com", "0987654321", "HCM", "2024-05-22"));
        users.add(new User("Lan Anh", 21, "la@003", "la@gmail.com", "0111222333", "Đà Nẵng", "2024-05-23"));

        // Gọi CRUD cho n đối tượng User
        crudUsers(users);
    }
}