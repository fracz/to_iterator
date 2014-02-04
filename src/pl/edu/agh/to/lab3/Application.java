package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.to.lab3.dataprovider.DataProvider;
import pl.edu.agh.to.lab3.dataprovider.SampleDataProvider;
import pl.edu.agh.to.lab3.entity.News;
import pl.edu.agh.to.lab3.entity.Photo;

public class Application {

    public static void main(String[] args) {
        new Application(new SampleDataProvider()).displayPromotedItems();
    }

    private final DataProvider dataProvider;

    public Application(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void displayPromotedItems() {
        Collection<News> allNews = dataProvider.getAllNews();
        Collection<Photo> allPhotos = dataProvider.getAllPhotos();

        ArrayList<News> promotedNews = new ArrayList<News>();
        ArrayList<Photo> promotedPhotos = new ArrayList<Photo>();

        for (News news : allNews) {
            if (news.isPromoted()) {
                promotedNews.add(news);
            }
            if (promotedNews.size() >= 10) {
                break;
            }
        }

        if (promotedNews.size() < 10) {
            for (Photo photo : allPhotos) {
                if (photo.promoted) {
                    promotedPhotos.add(photo);
                }
                if (promotedNews.size() + promotedPhotos.size() >= 10) {
                    break;
                }
            }
        }

        int total = promotedNews.size() + promotedPhotos.size();
        System.out.println("There are " + total + " promoted items to display!");

        for (News promoted : promotedNews) {
            System.out.println("News: " + promoted.information);
        }

        for (Photo promoted : promotedPhotos) {
            System.out.println(promoted.display());
        }
    }
}
