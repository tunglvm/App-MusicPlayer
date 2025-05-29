


import java.util.ArrayList;

public class SongsList {
    ArrayList<Songs> songs = new ArrayList<>();

    public ArrayList<Songs> addSong(Songs song) {
        songs.add(song);
        return songs;
    }

    public ArrayList<Songs> editSong(String newTitle, String songID) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongID().equals(songID)) {
                songs.get(i).setSongTitle(newTitle);
            }
        }
        return songs;
    }

    public ArrayList<Songs> deleteSong(String songID) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongID().equals(songID)) {
                songs.remove(i);
                break;
            }
        }
        return songs;
    }

    public void printSongsList() {
        for (Songs song : songs) {
            System.out.println("Song ID: " + song.getSongID() + " Title: " + song.getSongTitle());
        }
    }
}
