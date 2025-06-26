import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MusicPlayer extends PlaybackListener {

    //music slider only active when isPause is false
    //sometime isPause = true ==>> not sync
    //use to update isPause more synchronously
    private static final Object playSignal = new Object();

    //this is the reference to update GUI in this class
    private MusicPlayerGUI musicPlayerGUI;

    private Song currentSong; //creat class song to store songs
    //tupe: song
    public Song getCurrentSong(){
        return currentSong;
    }

    //list of PATH to song in playlist
    private ArrayList<Song> playList;

    //to keep track the index in the playlist
    private int currentPlaylistIndex;

    //use Jlayer library to create advancedPlayer -->> playing music
    private AdvancedPlayer advancedPlayer;

    //pause: use boolean flag to indicate wether the player has been pause or not
    private boolean isPause;

    //boolean flag to tell when has finished
    private boolean songFinished;

    //store the last frame when the playback is finished
    private int currentFrame;
    public void setCurrentFrame(int frame){
        currentFrame = frame;
    }