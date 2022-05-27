package Solution500_;

import java.util.Arrays;

public class Solution1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        if (candiesCount == null || queries == null)
            return null;
        boolean[] ret = new boolean[queries.length];
        long[] sum = new long[candiesCount.length + 1];
        sum[0] = 0;
        for (int i = 0; i < candiesCount.length; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ret[i] = (sum[query[0]] < (long)query[2] * (query[1] + 1)) && (sum[query[0] + 1] > query[1]);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] candiesCount = new int[]{46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,
                42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,
                33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,
                35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5};
        int[][] queries = new int[][]{{85,54,42}};
        Solution1744 s = new Solution1744();
        System.out.println(Arrays.toString(s.canEat(candiesCount,queries)));
    }
}
