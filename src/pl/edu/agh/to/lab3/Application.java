package pl.edu.agh.to.lab3;

import java.util.Collection;

public class Application {

    public static void main(String[] args) {
        Collection<Photo> photos = new PhotoProvider().findPhotos();
        Collection<News> news = new NewsManager().getAllNews();
        Ads advertismentBox = new Ads(photos, news);
        advertismentBox.displayPromotedItems();
    }
}
