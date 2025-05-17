//import Artist;
//import Songs;
//import Album;
//import Podcast;
//import User;
//import Playlist;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Music Player Test!");
        
        User user1 = new User("Tùng Lâm", 19, "23010874");
        System.out.println("User 1: " + user1.getUserID() + "  "+ user1.getName() ); 

        Songs song = new Songs("Lullaby", "IU001s005", "IU", "", "K-Pop", 261);
        System.out.println("Song: " + song.songTitle + " by " + song.Artist);

        Album album = new Album("Love Poem", "IU001", "IU", "Lullaby", "KaKao Entertainment", 1500);
        System.out.println("Album: " + album.albumTitle + " by " + album.Artist + ", copyright by " + album.Copyright);

        Artist artist = new Artist("IU", "IU16051993", "Korean", "16/05/1993", "Blueming", "Love poem");
        System.out.println("Artist: " + artist.Name);

        Podcast podcast = new Podcast("When life give you a watermelon", "PCC001", "Lam lanh lung", "sharing about life", 900);
        System.out.println("Podcast: " + podcast.podcastTitle + " by " + podcast.host + ", description: " + podcast.description + ", duration: " + podcast.duration + " seconds");

    }
}
