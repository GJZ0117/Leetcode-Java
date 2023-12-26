package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 284. Peeking Iterator
 */

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        if (iterator.hasNext()) {
            this.next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans = next;
        next = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}


// 二刷
class PeekingIterator_2 implements Iterator<Integer> {

    int index;
    List<Integer> list;

    public PeekingIterator_2(Iterator<Integer> iterator) {
        // initialize any member here.
        index = -1;
        list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index + 1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(++index);
    }

    @Override
    public boolean hasNext() {
        return index != list.size() - 1;
    }
}