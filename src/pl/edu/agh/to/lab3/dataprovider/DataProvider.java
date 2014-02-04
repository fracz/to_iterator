package pl.edu.agh.to.lab3.dataprovider;

import java.util.Collection;

import pl.edu.agh.to.lab3.entity.News;
import pl.edu.agh.to.lab3.entity.Photo;

public interface DataProvider {
    Collection<Photo> getAllPhotos();

    Collection<News> getAllNews();
}
