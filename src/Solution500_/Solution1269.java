package Solution500_;

public class Solution1269 {
    private static int MOD = 1_000_000_007;

    public int numWays(int steps, int arrLen) {
        assert steps >= 0 && arrLen >= 0;
        arrLen = Math.min(steps + 1, arrLen);
        int[] dp = new int[arrLen--];
        dp[0] = 1;
        for (int i = 0; i < steps; i++) {
            int pre = dp[0];
            dp[0] = (dp[0] + dp[1]) % MOD;
            for (int j = 1; j < arrLen; j++) {
                int curr = dp[j];
                dp[j] = ((pre + curr) % MOD + dp[j + 1]) % MOD;
                pre = curr;
            }
            dp[arrLen] = (pre + dp[arrLen]) % MOD;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution1269 s = new Solution1269();
        System.out.println(s.numWays(27,7));
    }
}
