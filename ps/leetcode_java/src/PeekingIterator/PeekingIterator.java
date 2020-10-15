package PeekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    boolean hasNextExist = false;
    int curValue = 0;
    Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        hasNextExist = iter.hasNext();
        if(hasNextExist)
            curValue = iter.next();
    }

    public Integer peek() {
        return curValue;
    }

    @Override
    public Integer next() {
        int ret = curValue;
        hasNextExist = iter.hasNext();
        if(hasNextExist)
            curValue = iter.next();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return hasNextExist;
    }
}
