package Solution500_;

public class Solution706 {
}


/**
 * 这个设计的非常糟糕，本来以为取巧的直接把可能的结果都存下来，结果时间并不占优
 */
class MyHashMap {
    private boolean[] keySet = new boolean[1000000 + 8];
    private int[] valueSet = new int[1000000 + 1];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        keySet[key] = true;
        valueSet[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return keySet[key] ? valueSet[key] : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        keySet[key] = false;
    }
}