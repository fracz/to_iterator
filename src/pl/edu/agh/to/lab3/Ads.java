package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Ads {
    private final Collection<Photo> allPhotos;

    private final Map<String, Collection<News>> allNews;

    public Ads(Collection<Photo> allPhotos, Map<String, Collection<News>> allNews) {
        this.allPhotos = allPhotos;
        this.allNews = allNews;
    }

    public void displayPromotedItems() {
        ArrayList<News> promotedNews = new ArrayList<News>();
        ArrayList<Photo> promotedPhotos = new ArrayList<Photo>();

        for (Collection<News> newsCollection : allNews.values()) {
            for (News news : newsCollection) {
                if (news.isPromoted()) {
                    promotedNews.add(news);
                }
                if (promotedNews.size() >= 10) {
                    break;
                }
            }
            if (promotedNews.size() >= 10) {
                break;
            }
        }

        if (promotedNews.size() < 10) {
            for (Photo photo : allPhotos) {
                if (photo.isPromoted()) {
                    promotedPhotos.add(photo);
                }
                if (promotedNews.size() + promotedPhotos.size() >= 10) {
                    break;
                }
            }
        }

        int t = promotedNews.size() + promotedPhotos.size();
        System.out.println("There are " + t + " promoted items to display!");

        for (News n : promotedNews) {
            System.out.println(NewsManager.renderNI(n));
        }

        for (Photo p : promotedPhotos) {
            System.out.println(p.display());
        }
    }
}
