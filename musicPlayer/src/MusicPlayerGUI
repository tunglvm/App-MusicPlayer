import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MusicPlayerGUI extends JFrame{

    //color configuration
    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;

    private MusicPlayer musicPlayer; //creat music player

    //use file explorer in app
    private JFileChooser jFileChooser;

    //creat panel to display title and artist
    private JLabel songTitle, songArtist;

    //creat button
    private JPanel playbackButton;

    //creat slider
    private JSlider playbackSlider;

    public MusicPlayerGUI(){
        //calls JFrame constructor out GUI and set header to "musicPlayer"
        super("Music Player");

        //set width and height
        setSize( 400, 600);  //creat a windown with width and height (400px x 6600p)

        //end process when app close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //launch the app at the center of screen
        setLocationRelativeTo(null);

        //prevent app from resize
        setResizable(false);

        setLayout(null);
        
        //Change th frame color
        getContentPane().setBackground(FRAME_COLOR);

        musicPlayer = new MusicPlayer(this); //reference to musicPlayer which created in "musicPlayer" class

        jFileChooser = new JFileChooser();
        //set a default PATH for filr explorer
        jFileChooser.setCurrentDirectory(new File("test song"));
        //fiter file chooser to only show .mp3 file
        jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3", "mp3"));

        addGuiComponents();

    }
    private void addGuiComponents(){ //tạo giao diện
        //add toolbar
        addToolBar();

        //load record image
        JLabel songImage = new JLabel(loadImage("src\\assets\\record.png"));
        songImage.setBounds(0, 50, getWidth() - 20, 225 );  //set position of song's image and width & height
        add(songImage);                                                //add song's image to GUI

        //Song title
        songTitle = new JLabel("Song Title");
        songTitle.setBounds(0, 285, getWidth() - 10, 30);        //set bound ==>> where the coponent locate at
        songTitle.setFont(new Font("Dialog", Font.BOLD, 24));     //set font
        songTitle.setForeground(TEXT_COLOR);                                //set text color
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);            //set algnment
        add(songTitle);                                                     //add song's title to GUI

        //song artist
        songArtist = new JLabel("Artist");
        songArtist.setBounds(0, 315, getWidth() - 10, 30);        //set bound
        songArtist.setFont(new Font("Dialog", Font.PLAIN, 24));    //set font
        songArtist.setForeground(TEXT_COLOR);                                //set text color
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);            //set algnment
        add(songArtist);

        //Playback slider
        playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(getWidth()/2 - 300/2, 365, 300, 40 );  //set place of slider
        playbackSlider.setBackground(null);    //none background

        //play song at any point using slider
        playbackSlider.addMouseListener(new MouseAdapter() {
            //2 actions ==>> press and release
            @Override
            public void mousePressed(MouseEvent e){
                //when user holding the slider ==>> pause the song
                musicPlayer.pauseSong();
            }
            @Override
            public void mouseReleased(MouseEvent e){
                //when user drop the slider ==>> play the song
                JSlider source = (JSlider) e.getSource();

                //get the frame value from where the user wants to palyback to
                int frame = source.getValue();

                //update the current frame in music player to this frame
                musicPlayer.setCurrentFrame(frame);

                //update current time in miliseconds                 //2.08 is explained in musicPlayer class
                musicPlayer.setCurrentTimeInMiliseconds((int) (frame / (2.08 * musicPlayer.getCurrentSong().getFramRatePerMiliseconds())));

                //resume the song
                musicPlayer.playCurrentSong();

                //toggle on pause button and toogle off play button
                enablePauseButtonDisablePlayButton();
            }
        });                                      
        add(playbackSlider);

        //playback button
        addPlaybackButtons();
    }

    private void addToolBar(){
        JToolBar toolBar = new JToolBar();                    //Creat a "toolbar"
        toolBar.setBounds(0, 0, getWidth(), 20);   //Set tthe "toolbar"

        //prevent toolbar from being moved
        toolBar.setFloatable(false);

        JMenuBar menuBar = new JMenuBar();                    //creat a "menu bar"  
        toolBar.add(menuBar);                                 //add "menu bar" to the "tool bar"



        //add song menu => loading option
        //add drop-down menu name "song"
        JMenu songMenu = new JMenu("Song");                  //creat a "song" button 
        menuBar.add(songMenu);                                 //add the "song" button to "menu bar"

        //add "load song" option in the menu
        JMenuItem loadSong = new JMenuItem("Load Song");  //creat"load song" option 
        loadSong.addActionListener(new ActionListener() {  //process when user click
            @Override
            public void actionPerformed(ActionEvent e){  //method actionPerformed will be called when user choose
                //on int is return to let program know what user did ==> prevent load song when user "cancel"
                int result = jFileChooser.showOpenDialog(MusicPlayerGUI.this); 
                File selectedFile = jFileChooser.getSelectedFile();  //creat file which is choosen

                //use result to check if user click the "open" button
                if(result == JFileChooser.APPROVE_OPTION && selectedFile != null){

                    //creat a song based on selected file
                    Song song = new Song(selectedFile.getPath());

                    //load song in musicplayer
                    musicPlayer.loadSong(song);

                    //update song title and artist
                    updateSongTitleAndArtist(song);

                    //update playback slider
                    updatePlaybackSlider(song);

                    //toggle on pause button and turn on play button
                    enablePauseButtonDisablePlayButton();
                }
            }
        });
        songMenu.add(loadSong);                                //add "load song" option to "song" drop-down menu

        //add song menu => loading option
        //add drop-down menu name "playlist"
        JMenu playlistMenu = new JMenu("Playlist");          //creat a "playlist" button 
        menuBar.add(playlistMenu);                             //add the "playlist" button to "menu bar"

        //creae playlist function
        //add items to playlist menu
        JMenuItem creatPlaylist = new JMenuItem("Create Playlist");  //creat "creat playlist" option 
        creatPlaylist.addActionListener(new ActionListener() {           //process when user click
            @Override
            public void actionPerformed(ActionEvent e){                  //method actionPerformed will be called when user choose
                //load music dialog
                new MusicPlaylistDialog(MusicPlayerGUI.this).setVisible(true);
            }
        });
        playlistMenu.add(creatPlaylist);                                 //add "creat playlist" option to "play list" drop-down menu
        
        //load playlist function
        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");    //creat "load playlist" option 
        loadPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileFilter(new FileNameExtensionFilter("Playlist", "txt"));
                jFileChooser.setCurrentDirectory(new File("test song"));

                int result = jFileChooser.showOpenDialog(MusicPlayerGUI.this);
                File selectedFile = jFileChooser.getSelectedFile();

                if(result == JFileChooser.APPROVE_OPTION && selectedFile != null){
                    //stop music which is playing
                    musicPlayer.stopSong();

                    //load music
                    musicPlayer.loadPlaylist(selectedFile);

                }
            }
        });
        playlistMenu.add(loadPlaylist);                                  //add "load playlist" option to "play list" drop-down menu

        add(toolBar);   
    }

    private void addPlaybackButtons(){
        //creat and add button
        playbackButton = new JPanel();
        playbackButton.setBounds(0, 435, getWidth() - 10, 80);  //set properties of button
        playbackButton.setBackground(null);

        //previous button
        JButton prevButton = new JButton(loadImage("src\\assets\\previous.png"));
        prevButton.setBorderPainted(false);  //set none to border
        prevButton.setBackground(null);    //set none background
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //go to privious song
                musicPlayer.prevSong();
            }
        });
        playbackButton.add(prevButton);      //show the button

        //play button
        JButton playButton = new JButton(loadImage("src\\assets\\play.png"));
        playButton.setBorderPainted(false);
        playButton.setBackground(null);
        playButton.addActionListener(new ActionListener() {  //CREAT RESUME FUNCTION
            @Override //switch to "pause" when music is playing
            public void actionPerformed(ActionEvent e){
                //toggle off the "Play Button" and toogle of the "Pause Button"
                enablePauseButtonDisablePlayButton();

                //play or resume song
                musicPlayer.playCurrentSong();
            }
        });
        playbackButton.add(playButton);       //show the button

        //pause butoon
        JButton pauseButton = new JButton(loadImage("src\\assets\\pause.png"));
        pauseButton.setBorderPainted(false); 
        pauseButton.setBackground(null);
        pauseButton.setVisible(false);
        //CREAT PAUSE FUNCTION
        pauseButton.addActionListener(new ActionListener() {  
            @Override  //switch to "play" button when music is pausing
            public void actionPerformed(ActionEvent e){
                //toggle off the "Pause Button" and toogle of the "Play Button"
                enablePlayButtonDisablePauseButton();

                //pause the song
                musicPlayer.pauseSong();
            }
        });
        playbackButton.add(pauseButton);             //show the button

        //next button
        JButton nextButton = new JButton(loadImage("src\\assets\\next.png"));
        nextButton.setBorderPainted(false); //set border color
        nextButton.setBackground(null);    //set the background
        playbackButton.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //go to next song in the playlist
                musicPlayer.nextSong();
            }
        });

        add(playbackButton);
    }   

    //function to make slider usable
    //update slider from "music player" class
    public void setPlaybackSliderValue(int frame){
        playbackSlider.setValue(frame); //set value of slider == frame
    }

    public void updateSongTitleAndArtist(Song song){
        //display the title and artist of the song 
        songTitle.setText(song.getSongTitle());      //call the getTitle func in "song" class
        songArtist.setText(song.getSongArtist());    //call the getAritsit func in "song" class
    }

    public void updatePlaybackSlider(Song song){
        //update MAX count for slider
        //set the MAX value of slider == song's length
        playbackSlider.setMaximum(song.getMp3File().getFrameCount()); 

        //creat song length lable by using "Hashtable" and "JLabel"
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();

        //set the beginning of song is 00:00
        JLabel labelBeginning = new JLabel("00:00"); //creat label
        labelBeginning.setFont(new Font("Dialog", Font.BOLD, 18));  //set the properties
        labelBeginning.setForeground(TEXT_COLOR);                            //set the properties

        //set the end of song
        JLabel labelEnd = new JLabel(song.getSpngLenght()); //creat label
        labelEnd.setFont(new Font("Dialog", Font.BOLD, 18));         //set the properties
        labelEnd.setForeground(TEXT_COLOR);                                   //set the properties

        //place coponents in table
        labelTable.put(0, labelBeginning);                           //time song been playing
        labelTable.put(song.getMp3File().getFrameCount(), labelEnd);   //total length of the song in formatted string

        playbackSlider.setLabelTable(labelTable);
        playbackSlider.setPaintLabels(true);

    }

    public void enablePauseButtonDisablePlayButton(){  //set to public => other classes can call this function
        //retrieve reference to play button from playbackbutton panel
        JButton playButton = (JButton) playbackButton.getComponent(1);
        JButton pauseButton = (JButton) playbackButton.getComponent(2);

        //turn off play button when music is playing
        playButton.setVisible(false);    //set the visible of playButton to off
        playButton.setEnabled(false);        //set the enable of playButton to off

        //turn on pause button 
        pauseButton.setVisible(true);    //set the visible of pauseButton to on
        pauseButton.setEnabled(true);        //set the enable of pauseButton to on
    }

     public void enablePlayButtonDisablePauseButton(){
        //retrieve reference to play button from playbackbutton panel
        JButton playButton = (JButton) playbackButton.getComponent(1);
        JButton pauseButton = (JButton) playbackButton.getComponent(2);

        //turn off play button when music is playing
        playButton.setVisible(true);    //set the visible of playButton to on
        playButton.setEnabled(true);        //set the enable of playButton to on

        //turn on pause button 
        pauseButton.setVisible(false);    //set the visible of pauseButton to off
        pauseButton.setEnabled(false);        //set the enable of pauseButton to off
    }


    private ImageIcon loadImage(String imagePATH){  //function used to load image for GUI
        try{

            //read the image file from the PATH
            BufferedImage image = ImageIO.read(new File(imagePATH));

            //return image  icon
            return new ImageIcon(image);
        }
        catch(Exception e){    //error
            e.printStackTrace();
        }

        //could not find result
        return null;
    }
    
}
