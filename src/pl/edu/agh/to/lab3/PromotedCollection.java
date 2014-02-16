package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class PromotedCollection implements Iterable<Promotable> {

    private final PromotedIterator iterator;

    public PromotedCollection(Collection<Photo> allPhotos, Map<String, Collection<News>> allNews) {
        iterator = new PromotedIterator(allPhotos, allNews);
    }

    @Override
    public Iterator<Promotable> iterator() {
        return iterator;
    }
}
