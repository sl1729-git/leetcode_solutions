package Solution500_;

import java.util.Arrays;

public class Solution705 {

}

class MyHashSet {
    private boolean[] keySet = new boolean[1000000 + 1];

    /** Initialize your data structure here. */
    public MyHashSet() {
        //Arrays.fill(keySet, false);
    }

    public void add(int key) {
        keySet[key] = true;
    }

    public void remove(int key) {
        keySet[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return keySet[key];
    }
}