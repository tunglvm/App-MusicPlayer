package musicPlayer;

import java.util.ArrayList;

import musicPlayer.EP;
import musicPlayer.Single;
import musicPlayer.Album;

public class Artist {
    private String name;
    private ArrayList<Album> albums;
    private ArrayList<Single> singles;
    private ArrayList<EP> eps;
    private String artistID;
    private String nationality;
    private String dateOfBirth;

    public Artist(String artistID, String name) {
        this.artistID = artistID;
        this.name = name;
        this.albums = new ArrayList<>();
        this.singles = new ArrayList<>();
        this.eps = new ArrayList<>();
    }

    public void setArtistInfo(String nationality, String dateOfBirth) {
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    public void addEP(EP ep) {
        this.eps.add(ep);
    }

    public void addSingle(Single single) {
        this.singles.add(single);
    }

    public String getArtistID() {
        return artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<EP> getEps() {
        return eps;
    }

    public ArrayList<Single> getSingles() {
        return singles;
    }

    public void setArtistProduct(ArrayList<Album> albums, ArrayList<EP> eps, ArrayList<Single> singles) {
        if (albums != null) {
            this.albums = albums;
        }
        if (eps != null) {
            this.eps = eps;
        }
        if (singles != null) {
            this.singles = singles;
        }
    }

    public void displayArtistInfo() {
        System.out.println("Artist ID: " + artistID + ", Name: " + name);
    }
}