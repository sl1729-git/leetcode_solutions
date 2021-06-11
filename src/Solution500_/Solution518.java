package Solution500_;

public class Solution518 {
    /**
     * 这一题也是动态规划，记dp[j]为在使用了[coin1,coin2,...,coin_i]
     * 这些硬币时，拥有的找零方案书，那么显然的，有dp[j + coin_i] =
     * dp[j] + dpPre[j + coin_i]，保证遍历顺序就可以简写为
     * dp[j + coin_i] += dp[j]
     *
     *
     * @param amount 需要找零的金额，需要大于等于0
     * @param coins 现在有的硬币种类
     * @return 所有找零的方案数
     */
    public int change(int amount, int[] coins) {
        assert amount >= 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 5;
        Solution518 s = new Solution518();
        System.out.println(s.change(amount, coins));
    }
}
