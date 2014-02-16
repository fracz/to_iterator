package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Collection<Photo> photos = new PhotoProvider().findPhotos();
        Map<String, Collection<News>> news = new NewsManager().getAllNews();
        Ads advertismentBox = new Ads(photos, news);
        advertismentBox.displayPromotedItems();
    }
}
