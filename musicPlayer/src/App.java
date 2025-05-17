//import Artist;
//import Songs;
//import Album;
//import Podcast;
//import User;
//import Playlist;

import musicPlayer.unittest.testUser;

public class App {
    public static void main(String[] args) throws Exception {
testUser.display();

        
        System.out.println("Music Player Test!");
        
        User user1 = new User("Tùng Lâm", 19, "23010874");
        System.out.println("User 1: " + user1.getUserID() + "  "+ user1.getName() + "\n"); 

        Group6_OOP_N02_term3_2025.musicPlayer.test.testSongs.getSongName();
        Songs song1 = new Songs("Lullaby", "IU001s005", "IU", "", "K-Pop", 261);
        System.out.println("Song: " + song1.songTitle + " by " + song1.Artist);
        Songs song2 = new Songs("unlucky", "IU001s001", "IU", "", "K-Pop", 231);
        System.out.println("Song: " + song2.songTitle + " by " + song2.Artist + "\n");


        Album album = new Album("Love Poem", "IU001", "IU", "Lullaby", "KaKao Entertainment", 1500);
        System.out.println("Album: " + album.albumTitle + " by " + album.Artist + ", copyright by " + album.Copyright);

        Artist artist = new Artist("IU", "IU16051993", "Korean", "16/05/1993", "Blueming", "Love poem");
        System.out.println("Artist: " + artist.Name);

        Playlist playlist = new Playlist("My Favorite Songs", "P001", "Tùng Lâm", "My favorite songs", 10);
        System.out.println("Playlist: " + playlist.playlistTitle + " by " + playlist.userID + ", description: " + playlist.description + ", number of songs: " + playlist.numberOfSongs);

        Podcast podcast = new Podcast("When life give you a watermelon", "PCC001", "Lam lanh lung", "sharing about life", 900);
        System.out.println("Podcast: " + podcast.podcastTitle + " by " + podcast.host + ", description: " + podcast.description + ", duration: " + podcast.duration + " seconds");

    }
}
