package musicPlayer.test;

import musicPlayer.App;
import musicPlayer.EP;
import musicPlayer.Artist;
import musicPlayer.AlbumList;
import musicPlayer.Songs;

public class TestApp {
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

        // ... các thao tác khác và in ra màn hình ...
    }
}