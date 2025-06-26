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

    //track how many miliseconds has passed since playing song
    //use for updating slider
    public int currentTimeInMiliseconds;
    public void setCurrentTimeInMiliseconds(int timeInMiliseconds){
        currentTimeInMiliseconds = timeInMiliseconds;
    }

    //constructor
    public MusicPlayer(MusicPlayerGUI musicPlayerGUI){
        this.musicPlayerGUI = musicPlayerGUI;
    }
    

    //functione to load song
    public void loadSong(Song song){
        currentSong = song;

        if(currentSong != null){
            playCurrentSong();
        }
    }

    public void loadPlaylist(File playlistFile){
        playList = new ArrayList<>();

        //store the PATHs from the txt file into the playlist
        try {
            FileReader fileReader = new FileReader(playlistFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //reach each line in the txt file and store into songPath variable
            String songPath;
            while ((songPath = bufferedReader.readLine()) != null) {
                //create song object based on song paths
                Song song = new Song(songPath);

                //add to the arraylist playlist
                playList.add(song);
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if(playList.size() > 0){
            //reset playback slider
            musicPlayerGUI.setPlaybackSliderValue(0);
            currentTimeInMiliseconds = 0;

            //update current song to the first song in playlist
            currentSong = playList.get(0);

            //start from the beginning
            currentFrame = 0;

            //update GUI
            musicPlayerGUI.enablePauseButtonDisablePlayButton();
            musicPlayerGUI.updateSongTitleAndArtist(currentSong);
            musicPlayerGUI.updatePlaybackSlider(currentSong);


            //start song
            playCurrentSong();

        }
    }

    void pauseSong(){
        if(advancedPlayer != null){
            //update pause flag
            isPause = true;
            // ==> stop the player
            stopSong();
        }
    }

    public void stopSong(){
        if(advancedPlayer != null){
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
    }

    public void nextSong(){
        //if there no song in the playlist
        if(playList == null){
            return;
        }

        //check to see if there is anysong next
        if(currentPlaylistIndex + 1 >playList.size() - 1){
            return;
        }

        //bug: user press pause when song is finished
        if(!songFinished){
            stopSong();
        }

        //increase current playlist index
        currentPlaylistIndex ++;

        //update current song
        currentSong = playList.get(currentPlaylistIndex);

        //reset frame
        currentFrame = 0;

        //reset time in milliseconds
        currentTimeInMiliseconds = 0;

        musicPlayerGUI.enablePauseButtonDisablePlayButton();
        musicPlayerGUI.updateSongTitleAndArtist(currentSong);
        musicPlayerGUI.updatePlaybackSlider(currentSong);

        //play th song
        playCurrentSong();
    }

    public void prevSong(){
        //if there no song in the playlist
        if(playList == null){
            return;
        }

        //check to see if there is anysong to go back
        if(currentPlaylistIndex - 1 < 0){
            return;
        }

        //bug: user press pause when song is finished
        if(!songFinished){
            stopSong();
        }

        //decrease current playlist index
        currentPlaylistIndex --;

        //update current song
        currentSong = playList.get(currentPlaylistIndex);

        //reset frame
        currentFrame = 0;

        //reset time in milliseconds
        currentTimeInMiliseconds = 0;

        musicPlayerGUI.enablePauseButtonDisablePlayButton();
        musicPlayerGUI.updateSongTitleAndArtist(currentSong);
        musicPlayerGUI.updatePlaybackSlider(currentSong);

        //play th song
        playCurrentSong();
    }

    //function to play song
    public void playCurrentSong(){
        if(currentSong == null){
            return; // prevent user press "play" before load songs
        }
        try{
            //read mp3 audio data
            FileInputStream fileInputStream = new FileInputStream(currentSong.getFilePATH());    //get filePATH from currentSong
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            // creat a new advanced player
            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            //start playing music
            startMusicThread();

            //star playback slider thread
            startPlaybackSliderThread();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    if(isPause){
                        synchronized(playSignal){
                            //bcause update slider thread will not work unless isPause is false
                            //==>>  update flag
                            isPause = false;

                            //notify the other thread to continue
                            //make sure isPause is false properly
                            playSignal.notify();
                        }

                        //resume music from the last frame when music is pause
                        advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
                    }                                          //MAX to capture all lengths of songs
                    else{
                        //playing music from start
                        advancedPlayer.play();
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //creat thread that handle updating slider
    private void startPlaybackSliderThread(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                if(isPause){
                    try{
                        //wait till its gets notified bt other thread to continue
                        //make sure isPause boolean flag is false properly before continuing
                        synchronized(playSignal){
                            playSignal.wait();
                            //this(startPlaybackSliderThread) thread will wait
                            //while plauMusicThread will execute ==>> this(startMusicThread) will update isPause flag to false
                            //notify the update slider thread to continue
                            //then both 2 thread will continue
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }

                }

                System.out.println("isPause: " + isPause);

                while(!isPause){   //set the condition is when it is not pause
                    try{
                    //increment current time in miliseconds
                    currentTimeInMiliseconds++;

                    //caculate into frame value
                    //this value is not accurate
                    //value of currentTimeInMiliseconds() is not matching with getFrame()
                    //==>> need to mutiply to 2.08 to make its accurate (but not 100% accurate)
                    int calculatedFrame = (int) ((double) currentTimeInMiliseconds * 2.08 * currentSong.getFramRatePerMiliseconds());

                    //update GUI
                    //need a reference to the GUI class
                    musicPlayerGUI.setPlaybackSliderValue(calculatedFrame);

                    //mimic 1 miliseconds using thread.sleep
                    Thread.sleep(1);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override //this method gets called when the song is finished or if player gets closer
    public void playbackStarted(PlaybackEvent evt) {
        System.out.println("Play Back Started");
        songFinished = false; //boolean flag to tell song is finished

    }

    @Override //this method gets called in the beginning of the song
    public void playbackFinished(PlaybackEvent evt) {
        System.out.println("Play Back Finished");
        
        if(isPause){
            // ||evt.getFrame() x (total frame / ms(song length)) = current frame||
            currentFrame += (int) ((double) evt.getFrame() * currentSong.getFramRatePerMiliseconds()); 
            //"The play (int start, int end)"
            //JLayer ADVANDCEDPLAYER expect "frame", not "miliseconds" value ==>> convert milisecond to frame
        }
        else{
            //when song ends
            songFinished = true;  //boolean flag to tell song is finished

            if(playList == null){
                //update GUI
                musicPlayerGUI.enablePlayButtonDisablePauseButton();
            }
            else{
                //last song in the playlist
                if(currentPlaylistIndex == playList.size() - 1){
                    //update GUI
                    musicPlayerGUI.enablePlayButtonDisablePauseButton();
                }
                else{
                    //go to next song in the playlist
                    nextSong();
                }
            }
        }
    }
}
