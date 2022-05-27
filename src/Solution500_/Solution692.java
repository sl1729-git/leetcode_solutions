package Solution500_;

import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!count.get(o1).equals(count.get(o2)))
                    return count.get(o1) - count.get(o2);
                else
                    return o2.compareTo(o1);
            }
        });
        for (String word:words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word:count.keySet()) {
            queue.add(word);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> ret = new ArrayList<>();
        while (!queue.isEmpty())
            ret.add(queue.poll());
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        Solution692 s = new Solution692();
        System.out.println(s.topKFrequent(words,1));
    }
}
