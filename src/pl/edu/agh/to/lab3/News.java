package pl.edu.agh.to.lab3;

public class News {
    private long publicationTimestamp;

    public String information;

    public News(String information, long publicationTimestamp) {
        this.information = information;
        this.publicationTimestamp = publicationTimestamp;
    }

    public boolean isPromoted() {
        // news are promoted for one day after publication
        return publicationTimestamp + 24 * 60 * 60 * 1000 > System.currentTimeMillis();
    }
}
