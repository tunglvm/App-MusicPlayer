package musicPlayer;

public class Artist {
    private String name;
    private Album album;
    private Single single;
    private EP ep;
    private String artistID;
    private String nationality;
    private String dateOfBirth;

    public Artist(String artistID, String name) {
        this.artistID = artistID;
        this.name = name;
    }

    public void setArtistInfo(String nationality, String dateOfBirth) {
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public void setArtistProduct(Album album, EP ep, Single single) {
        this.album = album;
        this.ep = ep;
        this.single = single;
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

    public EP getEp() {
        return ep;
    }

    public Single getSingle() {
        return single;
    }

    public void displayArtistInfo() {
        System.out.println("Artist ID: " + artistID + ", Name: " + name);
    }
}