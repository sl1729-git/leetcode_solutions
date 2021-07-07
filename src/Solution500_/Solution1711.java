package Solution500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1711 {
    public int solutionSlow(int[] deliciousness) {
        if (deliciousness == null)
            return 0;
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.sort(deliciousness);
        int ret = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            int current = deliciousness[i];
            for (Integer pre:count.keySet()) {
                int sum = current + pre;
                if ((sum & (sum - 1)) == 0 && sum != 0)
                    ret += count.get(pre);
            }
            count.put(current, count.getOrDefault(current, 0) + 1);
        }

        return ret;
    }

    /**
     * 这题黑历史，，，
     * @param deliciousness 菜品的美味值，不能为null，必须均为正数
     * @return 所有美味值对和为2的幂的组合数对1_000_000_007的取余
     */
    public int countPairs(int[] deliciousness) {
        if (deliciousness == null)
            return 0;
        Map<Integer, Integer> count = new HashMap<>();
        int max = Arrays.stream(deliciousness).max().getAsInt() * 2;
        int ret = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            int current = deliciousness[i];
            for (int sum = 1; sum <= max; sum <<= 1) {
                ret = (ret + count.getOrDefault(sum - current, 0)) % 1_000_000_007;
            }
            count.put(current, count.getOrDefault(current, 0) + 1);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] deliciousness = new int[]{1048576,1048576};
        Solution1711 s = new Solution1711();
        System.out.println(s.countPairs(deliciousness));
    }
}
