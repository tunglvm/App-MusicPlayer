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

    // Đã có sẵn
    public void setEPInfo(String EPTitle, Songs song1, Songs song2, Songs song3, Songs song4, Songs song5,
            Songs song6) {
        this.EPTitle = EPTitle;
        songsList.clear();
        songsList.add(song1);
        songsList.add(song2);
        songsList.add(song3);
        songsList.add(song4);
        songsList.add(song5);
        songsList.add(song6);
    }

    // Thêm phiên bản nhận danh sách động
    public void setEPInfo(String EPTitle, List<Songs> songs) {
        this.EPTitle = EPTitle;
        songsList.clear();
        songsList.addAll(songs);
    }

    public String getEPInfo() {
        StringBuilder str = new StringBuilder();
        str.append("EP Title: ").append(EPTitle).append("\n");
        int index = 1;
        for (Songs s : songsList) {
            str.append(index).append(". ").append(s.getSongInfo()).append("\n");
            index++;
        }
        return str.toString();
    }
}
