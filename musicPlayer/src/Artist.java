class Artist {
    String Name;
    Album Album;
    Single Single;
    EP EP;
    String ArtistID;
    String Nationality;
    String Dateofbirth;
    
    public Artist(String ArtistID, String Name){
        this.ArtistID= ArtistID;
        this.Name= Name;
    }
    public void setArtistInfo(String Nationality, String Dateofbirth){
        this.Nationality = Nationality;
        this.Dateofbirth = Dateofbirth;
    }
    public void setAitistProduct(Album Album, EP EP, Single Single){
        this.Album = Album;
        this.EP = EP;
        this.Single = Single;
    }

public void displayArtistInfo() {
        System.out.println("Artist: " + Name + " (ID: " + ArtistID + ")");
        System.out.println("Nationality: " + Nationality + " \nDate of Birth: " + Dateofbirth);
  
    
}
}