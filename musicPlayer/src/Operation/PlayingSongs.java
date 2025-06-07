package Operation;

import musicPlayer.Playlist;
import musicPlayer.Album;
import musicPlayer.Songs;
import java.util.List;

public class PlayingSongs {

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

    // Phát tất cả bài hát trong Album
    public void playFromAlbum(Album album) {
        System.out.println("Đang phát album: " + album.getAlbumTitle());
        List<Songs> songs = album.getSongs();
        if (songs == null || songs.isEmpty()) {
            System.out.println("Album không có bài hát nào.");
            return;
        }
        for (Songs song : songs) {
            playSong(song);
        }
    }

    // Phát một bài hát
    public void playSong(Songs song) {
        System.out.println("Đang phát: " + song.getTitle() + " - " + song.getArtist());
        // Thêm logic phát nhạc thực tế ở đây nếu cần
    }
}
