package pl.edu.agh.to.lab3;

public class Photo implements Promotable {
    private boolean promoted;

    private String photoUrl;

    public Photo(String photoUrl, boolean promoted) {
        this.photoUrl = photoUrl;
        this.promoted = promoted;
    }

    public String display() {
        return "Photo: " + photoUrl;
    }

    @Override
    public boolean isPromoted() {
        return promoted;
    }
}
