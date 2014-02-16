package pl.edu.agh.to.lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PromotableIterator implements Iterator<Promotable> {

    private final List<Iterator<? extends Promotable>> iterators = new ArrayList<Iterator<? extends Promotable>>();

    private final Iterator<Iterator<? extends Promotable>> iteratorsIterator;

    private Iterator<? extends Promotable> currentIterator;

    public PromotableIterator(Collection<Photo> allPhotos, Map<String, Collection<News>> allNews) {
        iterators.add(allPhotos.iterator());
        for (Collection<News> newsCollection : allNews.values())
            iterators.add(newsCollection.iterator());
        iteratorsIterator = iterators.iterator();
        nextIterator();
    }

    @Override
    public boolean hasNext() {
        if (currentIterator == null)
            return false;
        if (!currentIterator.hasNext()) {
            nextIterator();
            return hasNext();
        }
        return true;
    }

    @Override
    public Promotable next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return currentIterator.next();
    }

    @Override
    public void remove() {
        currentIterator.remove();
    }

    private void nextIterator() {
        if (iteratorsIterator.hasNext())
            currentIterator = iteratorsIterator.next();
        else
            currentIterator = null;
    }
}
