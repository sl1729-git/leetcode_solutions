package Solution301_499;

import java.util.Arrays;

public class Solution322 {
    private static int MAGICNUM = 0x3f3f3f3f;


    /**
     * 这个还是用动规解，记录的状态是有当前coins币值组的前提下,dp[i]记录最少要多少硬币
     *
     * 显然dp[i] = Math.min(dp[i], dp[i - coin])
     *
     * @param coins 拥有的硬币种类，非空且每一种均面值大于0
     * @param amount 需要找零的金额
     * @return 如果没有找零方案返回-1，如果amount小于0，返回0，如果amount大于0且有方案
     *      返回最少方案的硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAGICNUM);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == MAGICNUM ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;

        Solution322 s = new Solution322();
        System.out.println(s.coinChange(coins, amount));
    }
}
