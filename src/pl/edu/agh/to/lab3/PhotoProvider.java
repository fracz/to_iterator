package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;


public class PhotoProvider {

    private final Collection<Photo> samplePhotos = new ArrayList<Photo>();

    public PhotoProvider() {
        samplePhotos.add(new Photo("http://agh.edu.pl/photo2.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo3.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo4.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo5.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo6.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo7.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo8.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo9.jpg", true));
    }

    public Collection<Photo> findPhotos() {
        return samplePhotos;
    }
}
