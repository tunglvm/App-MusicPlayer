import java.util.ArrayList;
import java.util.List;

public class EP {
    String EPID;
    String EPTitle;
    List<Songs> songsList;

    public EP(String EPID) {
        this.EPID = EPID;
        this.songsList = new ArrayList<>();
    }

    public void setEPInfo(String EPTitle, Songs song1, Songs song2, Songs song3, Songs song4, Songs song5, Songs song6) {
        this.EPTitle = EPTitle;
        // Clear previous songs if any
        songsList.clear();
        // Add all songs to the list
        songsList.add(song1);
        songsList.add(song2);
        songsList.add(song3);
        songsList.add(song4);
        songsList.add(song5);
        songsList.add(song6);
    }

    public String getEPInfo() {
        StringBuilder str = new StringBuilder();
        str.append("EP Title: ").append(EPTitle).append("\n");

        int index = 1; // Biến đếm bài hát
        for (Songs s : songsList) {
            str.append(index).append(". ").append(s.getSongInfo()).append("\n");
            index++;
        }

        return str.toString();
    }
}


