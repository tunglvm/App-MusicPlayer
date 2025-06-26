import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new MusicPlayerGUI().setVisible(true);

                // Uncomment the following lines to test the Song class
                // Ensure the Song class is properly defined in your project
                // and the file path is correct.  
                // call Song song constructor
                // Song song = new Song("mp3MusicPlayer\\test song\\Anh Thanh Nien - HuyR (HQ).mp3"); 
                // System.out.println(song.getSongTitle());
                // System.out.println(song.getSongArtist());
            }
        });
    }
}
