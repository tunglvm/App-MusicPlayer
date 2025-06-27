package musicPlayer.Test.TestFile;

import java.util.ArrayList;
import java.util.Scanner;

import musicPlayer.Song;
import musicPlayer.SongList;

public class TestSongList {
    ArrayList<Songs> sl = new ArrayList<Songs>();

    public ArrayList<Songs> addList() {
        Songs s1 = new Songs("S001");
        s1.setSongInfo("Song A", "Pop", 200, "Artist A");
        Songs s2 = new Songs("S002");
        s2.setSongInfo("Song B", "Ballad", 180, "Artist B");
        Songs s3 = new Songs("S003");
        s3.setSongInfo("Song C", "Rock", 210, "Artist C");
        sl.add(s1);
        sl.add(s2);
        sl.add(s3);
        return sl;
    }

    public void testEditDelete() {
        SongList songsList = new SongList();
        ArrayList<Songs> songs = addList();
        for (Songs s : songs) {
            songsList.addSong(s);
        }

        songsList.printSongsList();

        // Dùng 1 Scanner duy nhất
        Scanner scanner = new Scanner(System.in);

        // Cập nhật thông tin bài hát
        System.out.println("Enter song ID to edit:");
        String songID = scanner.nextLine();

        System.out.println("Enter new song title:");
        String newTitle = scanner.nextLine();

        songsList.editSong(newTitle, songID);
        System.out.println("Danh sách bài hát sau khi sửa:");
        songsList.printSongsList();

        // Xóa bài hát
        System.out.println("Enter song ID to delete:");
        String delID = scanner.nextLine();

        songsList.deleteSong(delID);
        System.out.println("Danh sách bài hát sau khi xóa:");
        songsList.printSongsList();

        // Đóng scanner ở cuối chương trình
        scanner.close();
    }

    public void testDelete(SongList songsList, String songID) {
        songsList.deleteSong(songID);
        songsList.printSongsList();
    }

    public static void main(String[] args) {
        TestSongsList test = new TestSongsList();
        test.testEditDelete();
    }
}
