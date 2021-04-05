package Solution100_150;

import java.util.Arrays;
import java.util.HashMap;

public class Solution146 {
    public static void main(String[] args) {

    }
}

class LRUCache {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] keysLastedUse = new int[3001];
    private int iterTime = 0;
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Arrays.fill(keysLastedUse, 0);
    }

    public int get(int key) {
        keysLastedUse[key] = iterTime++;
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        keysLastedUse[key] = iterTime++;
        if (map.size() >= capacity && !map.containsKey(key)){
            int minkey = key;
            for (Integer oldKey:map.keySet()) {
                minkey = keysLastedUse[minkey] > keysLastedUse[oldKey] ? oldKey : minkey;
            }
            map.remove(minkey);
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */