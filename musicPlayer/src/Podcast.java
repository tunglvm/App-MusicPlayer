public class Podcast {
    String podcastTitle;
    String podcastID;
    String host;
    String description;
    int duration;

    public Podcast(String podcastTitle, String podcastID, String host, String description, int duration){
        this.podcastTitle = podcastTitle;
        this.podcastID = podcastID;
        this.host = host;
        this.description = description;
        this.duration = duration;
    }
    public String getPodcastTitle(String podcastID){
        String test = podcastID;
        return test;
    }
}
