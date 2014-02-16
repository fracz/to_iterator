package pl.edu.agh.to.lab3;

public class News implements Promotable {
    private long publicationTimestamp;

    private String information;

    public News(String information, long publicationTimestamp) {
        this.information = information;
        this.publicationTimestamp = publicationTimestamp;
    }

    @Override
    public boolean isPromoted() {
        // news are promoted for one day after publication
        return publicationTimestamp + 24 * 60 * 60 * 1000 > System.currentTimeMillis();
    }

    @Override
    public String display() {
        return "News: " + information;
    }
}
