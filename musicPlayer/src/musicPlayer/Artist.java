package musicPlayer;

public class Artist {
    private String artistID;
    private String name;
    private String nationality;
    private String dateOfBirth;
    private Album album;

    public Artist(String artistID, String name) {
        try {
            this.artistID = artistID;
            this.name = name;
        } catch (Exception e) {
            System.out.println("Lỗi trong Artist Constructor: " + e.getMessage());
        }
    }

    // Setters và getters
    public void setArtistInfo(String nationality, String dateOfBirth) {
        try {
            this.nationality = nationality;
            this.dateOfBirth = dateOfBirth;
        } catch (Exception e) {
            System.out.println("Lỗi trong setArtistInfo: " + e.getMessage());
        }
    }

    public void setArtistProduct(Album album) {
        try {
            this.album = album;
        } catch (Exception e) {
            System.out.println("Lỗi trong setArtistProduct: " + e.getMessage());
        }
    }

    public String getArtistID() {
        return artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        try {
            this.name = newName;
        } catch (Exception e) {
            System.out.println("Lỗi trong setName: " + e.getMessage());
        }
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
        try {
            System.out.println("Artist ID: " + artistID + ", Name: " + name);
        } catch (Exception e) {
            System.out.println("Lỗi trong displayArtistInfo: " + e.getMessage());
        }
    }
}
