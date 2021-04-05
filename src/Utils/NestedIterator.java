package Utils;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<List<NestedInteger>> stack = new Stack<>();
    private Stack<Integer> stackIndex = new Stack<>();
    private List<NestedInteger> current = null;
    private int currentIndex = 0;
    private List<Integer> flatten = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        current = nestedList;
        Integer tmp = flattenNext();
        while (tmp != null){
            flatten.add(tmp);
            tmp = flattenNext();
        }

        currentIndex = 0;
    }

    private Integer flattenNext(){
        while (currentIndex >= current.size() && !stack.isEmpty()){
            current = stack.pop();
            currentIndex = stackIndex.pop();
        }

        if (currentIndex >= current.size())
            return null;

        if (current.get(currentIndex).isInteger())
            return current.get(currentIndex++).getInteger();

        stack.push(current);
        stackIndex.push(currentIndex + 1);

        current = current.get(currentIndex).getList();
        currentIndex = 0;
        return flattenNext();
    }

    @Override
    public Integer next() {
        return flatten.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < flatten.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */