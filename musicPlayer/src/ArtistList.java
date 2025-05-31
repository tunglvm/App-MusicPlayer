

import java.util.ArrayList;

public class ArtistList {
    ArrayList<Artist> artists = new ArrayList<>();

    public ArrayList<Artist> addArtist(Artist artist) {
        artists.add(artist);
        return artists;
    }

    public ArrayList<Artist> editArtist(String newName, String artistID) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getArtistID().equals(artistID)) {
                artists.get(i).setName(newName);
            }
        }
        return artists;
    }

    public ArrayList<Artist> deleteArtist(String artistID) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getArtistID().equals(artistID)) {
                artists.remove(i);
                break;
            }
        }
        return artists;
    }

    public void printArtistList() {
        for (Artist artist : artists) {
            System.out.println("Artist ID: " + artist.getArtistID() + " Name: " + artist.getName());
        }
    }
}
