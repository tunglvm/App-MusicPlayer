package Operation;

import musicPlayer.Album;
import musicPlayer.Playlist;
import musicPlayer.Songs;
import java.util.List;

public class PlayingSongs {

    // Phát một bài hát Sinh viên B
    public void playSong(Songs song) {
        System.out.println("Đang phát: " + song.getTitle() + " - " + song.getArtist());
    }

    // Phát tất cả bài hát trong Album Sinh viên C
    // Gọi hàm của sinh viên B để phát từng bài hát
    public void playAllFromAlbum(Album album) {
        System.out.println("Đang phát album: " + album.getAlbumTitle());
        List<Songs> songs = album.getSongs();
        if (songs == null || songs.isEmpty()) {
            System.out.println("Album không có bài hát nào để phát.");
            return;
        }
        for (Songs song : songs) {
            playSong(song); // Gọi hàm của sinh viên B
        }
    }

    // Phát tất cả bài hát trong Playlist
    public void playFromPlaylist(Playlist playlist) {
        System.out.println("Đang phát playlist: " + playlist.getPlaylistName());
        List<Songs> songs = playlist.getSongs();
        if (songs == null || songs.isEmpty()) {
            System.out.println("Playlist không có bài hát nào.");
            return;
        }
        for (Songs song : songs) {
            playSong(song);
        }
    }
}
