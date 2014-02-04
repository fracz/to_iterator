package pl.edu.agh.to.lab3.dataprovider;

import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.to.lab3.entity.News;
import pl.edu.agh.to.lab3.entity.Photo;

public class SampleDataProvider implements DataProvider {

    private final Collection<Photo> samplePhotos = new ArrayList<Photo>();

    private final Collection<News> sampleNews = new ArrayList<News>();

    public SampleDataProvider() {
        sampleNews.add(new News("Obsolete news", 0));
        sampleNews.add(new News("Newest news", System.currentTimeMillis()));
        sampleNews.add(new News("One hour news", System.currentTimeMillis() - 60000));
        sampleNews.add(new News("Two hour news", System.currentTimeMillis() - 120000));
        sampleNews.add(new News("Another two hour news", System.currentTimeMillis() - 120000));
        sampleNews.add(new News("Another obsolete news", 100));
        sampleNews.add(new News("Super fresh news", System.currentTimeMillis() - 10));

        samplePhotos.add(new Photo("http://agh.edu.pl/photo1.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo2.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo3.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo4.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo5.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo6.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo7.jpg", true));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo8.jpg", false));
        samplePhotos.add(new Photo("http://agh.edu.pl/photo9.jpg", true));
    }

    @Override
    public Collection<Photo> getAllPhotos() {
        return samplePhotos;
    }

    @Override
    public Collection<News> getAllNews() {
        return sampleNews;
    }

}
