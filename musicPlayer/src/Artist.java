class Artist {
    String Name;
    Album Album;
    Single Single;
    String ArtistID;
    String Nationality;
    String Dateofbirth;
    
    public Artist(String Name, String ArtistID, String Nationality, String Dateofbirth, String Songs, Album Album, Single Single){
        this.Name= Name;
        this.ArtistID= ArtistID;
        this.Nationality = Nationality;
        this.Dateofbirth = Dateofbirth;
        this.Single = Single;
        this.Album= Album;
    }


}