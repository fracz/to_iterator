package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class PromotableCollection implements Iterable<Promotable> {

    private final PromotableIterator iterator;

    public PromotableCollection(Collection<Photo> allPhotos, Map<String, Collection<News>> allNews) {
        iterator = new PromotableIterator(allPhotos, allNews);
    }

    @Override
    public Iterator<Promotable> iterator() {
        return iterator;
    }
}
