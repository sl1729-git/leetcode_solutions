package Solution500_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Long, Integer> count = new HashMap<>();
        for (int[] doinoes:dominoes) {
            long tmp2 = (((long)Math.min(doinoes[0],doinoes[1])) << 32) + Math.max(doinoes[0], doinoes[1]);
            count.put(tmp2, count.getOrDefault(tmp2, 0) + 1);
        }
        int ret = 0;
        for (Long key:count.keySet()) {
            int countNum = count.get(key);
            ret += countNum * (countNum - 1) / 2;
        }
        return ret;
    }
}
