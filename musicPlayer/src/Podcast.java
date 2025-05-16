public class Podcast {
    String podcastTitle;
    String podcastID;
    String host;
    String description;
    String category;
    int duration;

    public Podcast(String podcastTitle, String podcastID, String host, String description, String category, int duration){
        this.podcastTitle = podcastTitle;
        this.podcastID = podcastID;
        this.host = host;
        this.description = description;
        this.category = category;
        this.duration = duration;
    }

    public static String getPodcastTitle(String podcastID){
        String ID = podcastID;
        return ID;
    }
}
