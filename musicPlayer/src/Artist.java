class Artist {
    String Name;
    String ArtistID;
    String Nationality;
    String Dateofbirth;
    String Songs;
    String Album;
    
    public Artist(String Name, String ArtistID, String Nationality, String Dateofbirth, String Songs, String Album){
        this.Name= Name;
        this.ArtistID= ArtistID;
        this.Nationality = Nationality;
        this.Dateofbirth = Dateofbirth;
        this.Songs= Songs;
        this.Album= Album;
    }

    public static String getArtistName(String ArtistID){
        String ID1 = ArtistID;
        return ID1;
    }

}