package Solution500_;

import java.util.Arrays;

public class Solution1449 {

    /**
     *
     * @param cost 每个数的开销，必须均大于0
     * @param target 目标开销
     * @return 如果存在一种组合使得所有数字的开销和为target，
     * 则返回其中构成最大的一组；否则返回"0"
     */
    public String largestNumber(int[] cost, int target) {
        if (target <= 0)
            return "0";
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c:cost) {
            for (int i = c; i < dp.length; i++) {
                dp[i] = dp[i - c] + 1 > dp[i] ? dp[i - c] + 1 : dp[i];
            }
        }

        int cuurentIndex = dp.length - 1;
        if (dp[cuurentIndex] <= 0)
            return "0";
        StringBuffer ret = new StringBuffer();

        for (int i = cost.length - 1; i >= 0; i--) {
            int currentCost = cost[i];
            while (cuurentIndex >= currentCost && dp[cuurentIndex] == dp[cuurentIndex - currentCost] + 1) {
                ret.append((char)('1' + i));
                cuurentIndex -= currentCost;
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        int[] costs = new int[]{4,3,2,5,6,7,2,5,5};
        Solution1449 s = new Solution1449();
        System.out.println(s.largestNumber(costs, 9));
    }
}
