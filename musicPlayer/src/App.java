//import Artist;
//import Songs;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Music Player Test!");

        String test = Artist.getArtistName("Artist's ID");
        System.out.println(test);
        String test1 = Songs.getSongName("Song's Name");
        System.out.println(test1);
    }
}
