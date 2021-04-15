package Solution151_300;

public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[][] dp = new int[2][nums.length + 1];
        int len = nums.length;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + nums[i-1];
        }

        return Math.max(dp[0][len], dp[1][len]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        Solution198 s = new Solution198();
        System.out.println(s.rob(nums));
    }
}
