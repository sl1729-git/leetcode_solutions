package Solution500_;

import java.util.Arrays;

public class Solution879 {
    private static int MOD = 1_000_000_000 + 7;

    /**
     * 这个也是动态规划，dp[i][j]表示迭代到任务(group,profit)时，
     * 允许i名员工参与，盈利大于等于j的不同方案数
     *
     * 于是有dp[i][j] += dp[i - group][j-profit]
     * 注意若j-profit小于0则记为0，实际上也可以允许负数的索引
     *
     * @param n 允许的员工数量
     * @param minProfit 最小的盈利要求，需要是一个大于等于0的数
     * @param group 每一组盈利任务的员工数量要求，非空，每一项均大于0
     * @param profit 每一组预期的盈利能力，非空，每一项均大于0，且长度和group一致
     * @return 返回达成minProfit要求的方案数
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        assert group != null && profit != null && group.length == profit.length;
        int sum = Arrays.stream(profit).sum();
        if (n <= 0 || sum < minProfit || profit.length == 0)
            return 0;

        long[][] dp = new long[n + 1][minProfit + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 0; i < group.length; i++) {
            int curentGroup = group[i];
            int currentProfit = profit[i];
            for (int j = dp.length - 1; j >= curentGroup; j--) {
                for (int k = 0; k < dp[j].length; k++) {
                    int index = k > currentProfit ? k - currentProfit : 0;
                    dp[j][k] = (dp[j][k] + dp[j - curentGroup][index]) % MOD;
                }
            }
        }

        return (int)dp[n][minProfit];
    }

    public static void main(String[] args) {
        int[] group  = new int[]{2,3,5};
        int[] profit = new int[]{6,7,8};
        int n = 10, minProfit = 5;

        Solution879 s = new Solution879();

        System.out.println(s.profitableSchemes(n, minProfit, group, profit));
    }
}
