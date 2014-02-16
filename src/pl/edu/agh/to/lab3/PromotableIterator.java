package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Iterator;

public class PromotableIterator implements Iterator<Promotable> {

    private final Iterator<? extends Promotable> photoIterator;

    public PromotableIterator(Collection<Photo> allPhotos) {
        photoIterator = allPhotos.iterator();
    }

    @Override
    public boolean hasNext() {
        return photoIterator.hasNext();
    }

    @Override
    public Promotable next() {
        return photoIterator.next();
    }

    @Override
    public void remove() {
        photoIterator.remove();
    }
}
