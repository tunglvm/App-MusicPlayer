
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    public void run(){
        Songs song1 = new Songs("IUAFB001");
        Songs song2 = new Songs("IUAFB002");
        Songs song3 = new Songs("IUAFB003");
        Songs song4 = new Songs("IUAFB004");
        Songs song5 = new Songs("IUAFB005");
        Songs song6 = new Songs("IUAFB006");

        song1.setSongInfo("Autumn morning", "K-pop", 218);
        song2.setSongInfo("Secret Garden", "K-pop", 224);
        song3.setSongInfo("Sleepless rainy night", "K-pop", 266);
        song4.setSongInfo("Last night story", "K-pop", 233);
        song5.setSongInfo("By the stream", "K-pop", 337);
        song6.setSongInfo("Everyday with you", "K-pop", 224);

        EP EP1 = new EP("IUEPAFB");
        EP1.setEPInfo("A Flower Bookmark", song1, song2, song3, song4, song5, song6);

        Artist IU = new Artist("ATS001", "IU");
        IU.setArtistInfo("Korean", "16-5-1993");
        IU.setAitistProduct(null, EP1, null);

        IU.displayArtistInfo();

        Album album1 = new Album("A Flower Bookmark", "IUEPAFB", IU, song1, "Korean Copyright", 1500);
        album1.setAlbumInfo("A Flower Bookmark", IU, song1, "Korean Copyright", 1500);
        album1.displayAlbumInfo();

        User user1 = new User("Tùng Lâm", 19, "tunglvm001");
        user1.displayUserInfo();


        System.out.println(EP1.getEPInfo());
    }
}



