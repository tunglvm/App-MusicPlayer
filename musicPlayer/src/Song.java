import com.mpatric.mp3agic.Mp3File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import java.io.File;
import javax.sound.sampled.AudioFileFormat;

//class used to describe song
public class Song {
    private String songTitle;
    private String songArtist;
    private String spngLenght; //TYPO ==>> songLength
    private String filePATH;
    private Mp3File mp3File;
    private double framRatePerMiliseconds; //Used to calculate current frame for "resume" function 


    /**
     * use jaudiotagger(lib) to creat an audiofile obj to read mp3 file's information
     * @param filePATH
     */
    public Song(String filePATH){ //constructor for "Song"
        this.filePATH = filePATH;
        try{
            mp3File = new Mp3File(filePATH);
            //Calculate frame rate per miliseconds for "resume" function
            // ALGORITHM: current frame =  evt.getFrame() x (total frame / ms(song length))
            //==>> frame rate per miliseconds = total frame / song length in miliseconds
            framRatePerMiliseconds = (double) mp3File.getFrameCount() / mp3File.getLengthInMilliseconds();
            spngLenght = convertToSongLengthFormat();


            //use jaudiotagger(lib) to creat an audiofile obj to read mp3 file's information
            AudioFile audioFile = AudioFileIO.read(new File(filePATH));

            //read throught the meta data of the audiofile
            Tag tag = audioFile.getTag();
            if(tag != null){
                songTitle = tag.getFirst(FieldKey.TITLE);
                songArtist = tag.getFirst(FieldKey.ARTIST);
            }
            else{ //could not read meta data of song 
                 //==>> print "N/A" for both title and artist
                songTitle = "N/A";
                songArtist = "N/A";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //method: creat formatted string to display song's duration
    private String convertToSongLengthFormat(){ 
        long minutes = mp3File.getLengthInSeconds() / 60; //get minutes value
        long seconds = mp3File.getLengthInSeconds() % 60; //get seconds value
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        return formattedTime;
    }

    //getters
    public String getSongTitle() {
        return songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSpngLenght() {
        return spngLenght;
    }

    public String getFilePATH() {
        return filePATH;
    }

    public Mp3File getMp3File() {
        return mp3File;
    }

    public double getFramRatePerMiliseconds() {
        return framRatePerMiliseconds;
    }
}
