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


        
        User user = new User("Tùng Lâm", 19, "23010874");
        System.out.println(user.userId + "  "+ user.getName() ); 

        Songs song = new Songs("Lullaby", "IU001s005", "IU", "", "K-Pop", 261);
        System.out.println(song);

        Album album = new Album("Love Poem", "IU001", "IU", "Lullaby", "KaKao Entertainment", 1500);
        System.out.println(album);

        Artist artist = new Artist("IU", "IU16051993", "Korean", "16/05/1993", "Blueming", "Love poem");
        System.out.println(artist);
    }
}
