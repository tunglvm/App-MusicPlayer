//import Artist;
//import Songs;
//import Album;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Music Player Test!");

        String test = Artist.getArtistName("Artist's ID");
        System.out.println(test);
        String test1 = Songs.getSongName("Song's Name");
        System.out.println(test1);
        String test2 = Album.getAlbumTitle("Album's ID");
        System.out.println(test2);

        Songs song = new Songs("Lullaby", "IU001s005", "IU", "K-Pop", 261);
        System.out.println(song);

    }
}
