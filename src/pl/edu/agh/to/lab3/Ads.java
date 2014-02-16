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
        ArrayList<Promotable> promoted = new ArrayList<Promotable>();
        PromotableCollection promotableCollection = new PromotableCollection(allPhotos, allNews);

        for (Promotable promotable : promotableCollection) {
            if (promotable.isPromoted()) {
                promoted.add(promotable);
                if (promoted.size() > 10)
                    break;
            }
        }

        System.out.println("There are " + promoted.size() + " promoted items to display!");

        for (Promotable promotedItem : promoted) {
            System.out.println(promotedItem.display());
        }
    }
}
