package Solution301_499;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution451 {
    /**
     * 注意这一题没有说明字符一定是ACSII字符，所以不可以用256长度的数组去计算频数
     * @param s 需要进行按字符频率排序的字符串
     * @return 经过统计字符出现频率，从高到低的排序字符后返回
     */
    public String frequencySort(String s) {
        if (s == null)
            return null;
        Map<Character, Integer> count = new HashMap<>();
        for (char currentChar:s.toCharArray()) {
            count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);
        }
        int[][] pairs = new int[count.size()][2];
        int index = 0;
        for (Character key:count.keySet()) {
            pairs[index][0] = key;
            pairs[index][1] = count.get(key);
            index++;
        }

        StringBuilder ret = new StringBuilder();
        Arrays.sort(pairs, (o1, o2) -> Integer.compare(o2[1],o1[1]));
        for (int[] pair : pairs) {
            int times = pair[1];
            char currentChar = (char) pair[0];
            for (int j = 0; j < times; j++) {
                ret.append(currentChar);
            }
        }

        return ret.toString();
    }
}
