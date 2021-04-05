package Solution500_;

import Utils.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1202_2 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind union = new UnionFind(s.length());

        for (List<Integer> pair:pairs) {
            union.union(pair.get(0), pair.get(1));
        }

        char[] charArray = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> group = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            int root = union.find(i);
            group.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
        }

        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            int root = union.find(i);
            ret.append(group.get(root).poll());
        }
        return ret.toString();
    }
}
