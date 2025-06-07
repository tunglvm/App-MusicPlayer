package musicPlayer;

public class Artist {
    private String artistID;
    private String name;
    private String nationality;
    private String dateOfBirth;
    private Album album;

    public Artist(String artistID, String name) {
        this.artistID = artistID;
        this.name = name;
    }

    public void setArtistInfo(String nationality, String dateOfBirth) {
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public void setArtistProduct(Album album) {
        this.album = album;
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

    public Album getAlbum() {
        return album;
    }

    public void displayArtistInfo() {
        System.out.println("Artist ID: " + artistID + ", Name: " + name);
    }
}