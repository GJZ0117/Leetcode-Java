package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 */

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                list.add(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (list.isEmpty()) {
            return -1;
        } else {
            Integer res = list.get(0);
            list.remove(0);
            return res;
        }
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}