package musicPlayer.Test.TestFile;

import musicPlayer.Artist;
import musicPlayer.ArtistList;

public class TestArtistList {
    public static void main(String[] args) {
        ArtistList artistList = new ArtistList();

        Artist artist1 = new Artist("A001", "IU");
        Artist artist2 = new Artist("A002", "Sơn Tùng");
        Artist artist3 = new Artist("A003", "Jack");

        artistList.addArtist(artist1);
        artistList.addArtist(artist2);
        artistList.addArtist(artist3);

        System.out.println("Danh sách nghệ sĩ ban đầu:");
        artistList.printArtistList();

        artistList.editArtist("HIEUTHUHAI", "A003");

        System.out.println("\nSau khi sửa tên nghệ sĩ:");
        artistList.printArtistList();

        artistList.deleteArtist("A003");

        System.out.println("\nSau khi xóa nghệ sĩ A003:");
        artistList.printArtistList();
    }
}