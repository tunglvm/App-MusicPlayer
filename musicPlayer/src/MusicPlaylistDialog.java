import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



//creat a dialog box
public class MusicPlaylistDialog extends JDialog { //inherit form JDialog

    private MusicPlayerGUI musicPlayerGUI; //call the construtor of MusicPlayerGUI

    //store all the path to be written in a txr file (when user load playlist)
    private ArrayList<String> songPATHs;

    public MusicPlaylistDialog(MusicPlayerGUI musicPlayerGUI){
        this.musicPlayerGUI = musicPlayerGUI;

        //instantiate the songPATH list
        songPATHs = new ArrayList<>();

        //config dialog
        setTitle("Create Playlist");
        setSize(400, 400);  //set the size of dialog box
        setResizable(false);  //not allow user resize the windown(dialog box)
        getContentPane().setBackground(MusicPlayerGUI.FRAME_COLOR);
        setLayout(null);
        setModal(true); //this property maikes it so that the dialog has to give focus
        setLocationRelativeTo(musicPlayerGUI);  //config the dialog lay on top of main windown

        addDialogComponents();
    }

    private void addDialogComponents(){
        //container to hold each song path
        JPanel songContainer = new JPanel(); //create a Panel 
        //The components in the panel will be arranged vertically (from top to bottom)
        songContainer.setLayout(new BoxLayout(songContainer, BoxLayout.Y_AXIS));
        songContainer.setBounds((int) (getWidth() * 0.025), 10, (int) (getWidth() * 0.90), (int) (getHeight() * 0.75));
        // x: 2.5% of dialog width from left margin
        // y: 10 pixels from top margin
        // width: 90% of dialog width
        // height: 75% of dialog height
        add(songContainer); //Add songContainer to dialog (JDialog).

        /*
         *                    ADD SONG BUTTON
         */
        JButton addSongButton = new JButton("Add");
        addSongButton.setBounds(60, (int) (getWidth() * 0.80), 100, 25);     //set positon, width and height
        addSongButton.setFont(new Font("Dialog", Font.BOLD, 14));                 //set the font of the text on the button

        //add functionality to the button
        addSongButton.addActionListener(new ActionListener() {  //process when user click
            @Override
            public void actionPerformed(ActionEvent e){        //method actionPerformed will be called when user choose

                //open file explorer
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3", "mp3")); //Only allow selecting files with mp3 extension.
                //The starting directory is "test song" (user need to make sure that directory exists)
                jFileChooser.setCurrentDirectory(new File("test song"));

                //This is an integer variable (int) used to store the result of the user's action when the file selection dialog (JFileChooser) appears
                int result = jFileChooser.showOpenDialog(MusicPlaylistDialog.this);

                File selectedFile = jFileChooser.getSelectedFile();
                //Click "Open" (OK) → result == JFileChooser.APPROVE_OPTION
                //If the user selects nothing (or an error occurs), then selectedFile will be null
                if(result == jFileChooser.APPROVE_OPTION && selectedFile != null){
                    JLabel filePathLabel = new JLabel(selectedFile.getPath());
                    filePathLabel.setFont(new Font("Dialog", Font.BOLD, 12));
                    filePathLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    //add to the list
                    songPATHs.add(filePathLabel.getText());

                    //add to container
                    songContainer.add(filePathLabel);

                    //refresh dialog to show nearly add JLabel
                    songContainer.revalidate();

                }
            }
        });
        add(addSongButton);


        
        /*
         *            SAVE SONG BUTTON
         */
        JButton savePlaylistButton = new JButton("save");
        savePlaylistButton.setBounds(215, (int) (getWidth() * 0.80), 100, 25); //set positon, width and height
        savePlaylistButton.setFont(new Font("Dialog", Font.BOLD, 14));              //set the font of the text on the button
        
        savePlaylistButton.addActionListener(new ActionListener() {  //process when user click
            @Override
            public void actionPerformed(ActionEvent e){        //method actionPerformed will be called when user choose
                try{
                    JFileChooser jFileChooser = new JFileChooser();
                    //The starting directory is "test song" (user need to make sure that directory exists)
                    jFileChooser.setCurrentDirectory(new File("test song"));

                    //This is an integer variable (int) used to store the result of the user's action when the file selection dialog (JFileChooser) appears
                    int result = jFileChooser.showSaveDialog(MusicPlaylistDialog.this);

                    if(result == jFileChooser.APPROVE_OPTION){
                        //use getSelectedFile() to get reference to the file about to save
                        File selectFile = jFileChooser.getSelectedFile();

                        //convert to .txt file if not done so already
                        //this will check if the file does not have the .txt extention
                        //Take the length of the file name and subtract 4 → to determine the last 4 characters (file extension)
                        //==>>Compare the cut string with .txt, case insensitive
                        if (!selectFile.getName().substring(selectFile.getName().length() - 4).equalsIgnoreCase(".txt")) {
                            selectFile = new File(selectFile.getAbsolutePath() + ".txt");
                        }

                        //create the new file at destination directory
                        selectFile.createNewFile();

                        //write all song path into this file
                        FileWriter fileWriter = new FileWriter(selectFile);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //huffer = bộ đệm
                        //thay vì lưu vào ổ cứng thì buffer sẽ ghi vào RAM

                        //interate through song list and write each into th file
                        //each song will be written in its own row
                        for(String songPATH : songPATHs){
                            bufferedWriter.write(songPATH + "\n");
                        }
                        bufferedWriter.close(); //close the buffer

                        //display success dialog
                        JOptionPane.showMessageDialog(MusicPlaylistDialog.this, "Successfully created playlist");
                        //create a pop-up windown with text

                        //close the dialog
                        MusicPlaylistDialog.this.dispose();
                    }
                
                }
                catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        add(savePlaylistButton);
    }
}
