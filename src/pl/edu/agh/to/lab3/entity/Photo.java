package pl.edu.agh.to.lab3.entity;

public class Photo {
    public boolean promoted;

    private String photoUrl;

    public Photo(String photoUrl, boolean promoted) {
        this.photoUrl = photoUrl;
        this.promoted = promoted;
    }

    public String display() {
        return "Photo: " + photoUrl;
    }
}
