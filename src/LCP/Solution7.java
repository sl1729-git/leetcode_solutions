package LCP;

import java.util.Arrays;

public class Solution7 {
    /**
     * 动态规划解决
     * @param n 小朋友数量
     * @param relation 小朋友的edge
     * @param k 传递次数
     * @return 有多少种0号小朋友传递给n-1号小朋友的方案
     */
    public int numWays(int n, int[][] relation, int k) {
        assert n > 1 && relation != null;
        Arrays.sort(relation, (o1,o2)->Integer.compare(o2[1],o1[1]));
        int[] count = new int[n];
        count[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] send:relation) {
                next[send[1]] += count[send[0]];
            }
            count = next;
        }

        return count[n-1];
    }
}
