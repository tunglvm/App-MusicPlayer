package musicPlayer.Test.OperationTest;

import Operation.MusicLibrary;
import musicPlayer.Songs;

public class TestMusicLibrary {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();

        Songs song1 = new Songs("S001");
        song1.setSongInfo("Love Poem", "Pop", 200, "IU");
        Songs song2 = new Songs("S002");
        song2.setSongInfo("Song B", "Ballad", 180, "IU");
        Songs song3 = new Songs("S003");
        song3.setSongInfo("Sóng gió", "Rock", 210, "Jack");
        Songs song4= new Songs("S004");
        song4.setSongInfo("Đừng làm trái tim anh đau", "Hip Hop", 240, "Sơn Tùng");

        library.addSong(song1);
        library.addSong(song2);
        library.addSong(song3);
        library.addSong(song4);

        System.out.println("Hiển thị bài hát của IU:");
        library.displaySongsByArtist("IU");

        System.out.println("\nHiển thị bài hát của Jack:");
        library.displaySongsByArtist("Jack");

        System.out.println("\nHiển thị bài hát của Sơn Tùng:");
        library.displaySongsByArtist("Sơn Tùng");
    }
}
