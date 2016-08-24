package hathibelagal.github.io.oldstackreader;

/**
 * Created by Hathibelagal on 5/8/16.
 */
public class Question {

    private String title;
    private String authorDisplayName;
    private String authorPhoto;
    private int score;
    private int viewCount;
    private long creationDate;
    private boolean isAnswered;
    private String link;
    private String[] tags;

    public Question(String title, String authorDisplayName, String authorPhoto, int score,
                    int viewCount, long creationDate, boolean isAnswered, String link,
                    String[] tags) {
        this.title = title;
        this.authorDisplayName = authorDisplayName;
        this.authorPhoto = authorPhoto;
        this.score = score;
        this.viewCount = viewCount;
        this.creationDate = creationDate;
        this.isAnswered = isAnswered;
        this.link = link;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTagsAsString() {
        String output = "";
        for(String tag:tags) {
            output=output + " #" + tag + ",";
        }
        if(output.endsWith(","))
            output = output.substring(0, output.length()-1);
        return output;
    }

    public String getScoreAsString() {
        String suffix = " points";
        if(score == 1) suffix = " point";
        return score + suffix;
    }

    public String getViewCountAsString() {
        String suffix = " views";
        if(viewCount == 1) suffix = " view";
        return viewCount + suffix;
    }
}
