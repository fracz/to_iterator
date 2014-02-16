package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class PromotedIterator implements Iterator<Promotable> {

    private final PromotableIterator iterator;

    private Promotable nextPromoted = null;

    public PromotedIterator(Collection<Photo> allPhotos, Map<String, Collection<News>> allNews) {
        this(new PromotableIterator(allPhotos, allNews));
    }

    public PromotedIterator(PromotableIterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (nextPromoted != null)
            return true;
        return findNextPromoted();
    }

    @Override
    public Promotable next() {
        if (!hasNext())
            throw new NoSuchElementException();
        try {
            return nextPromoted;
        } finally {
            nextPromoted = null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private boolean findNextPromoted() {
        while (iterator.hasNext()) {
            Promotable promotable = iterator.next();
            if (promotable.isPromoted()) {
                nextPromoted = promotable;
                return true;
            }
        }
        return false;
    }
}
