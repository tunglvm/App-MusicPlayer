package musicPlayer;

import java.util.ArrayList;

public class AlbumList {
    ArrayList<Album> albums = new ArrayList<>();

    public ArrayList<Album> addAlbum(Album album) {
        albums.add(album);
        return albums;
    }

    public ArrayList<Album> editAlbum(String newTitle, String albumID) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getAlbumID().equals(albumID)) {
                albums.get(i).setAlbumTitle(newTitle);
            }
        }
        return albums;
    }

    public ArrayList<Album> deleteAlbum(String albumID) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getAlbumID().equals(albumID)) {
                albums.remove(i);
                break;
            }
        }
        return albums;
    }

    public void printAlbumList() {
        for (Album album : albums) {
            System.out.println("Album ID: " + album.getAlbumID() + " Title: " + album.getAlbumTitle());
        }
    }
}
