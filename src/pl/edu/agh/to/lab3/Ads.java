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
        ArrayList<Promotable> promotedList = new ArrayList<Promotable>();
        PromotedCollection promotedCollection = new PromotedCollection(allPhotos, allNews);

        for (Promotable promotedItem : promotedCollection) {
            promotedList.add(promotedItem);
            if (promotedList.size() > 10)
                break;
        }

        System.out.println("There are " + promotedList.size() + " promoted items to display!");

        for (Promotable promotedItem : promotedList) {
            System.out.println(promotedItem.display());
        }
    }
}
