public class Solution213 {

    /**
     *
     * @param nums nums中每一个元素均大于等于0
     * @return nums为null返回0，不为null计算最有解
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //因为假设是开通和结尾不取的情况，如果只有一户，那开通和结尾是同一个
        //所以要特别处理
        if (nums.length == 1)
            return nums[0];

        int[][] dp = new int[2][nums.length + 1];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + nums[i-1];
        }

        int ret = Math.max(dp[0][len - 1], dp[1][len - 1]);

        for (int i = len - 1; i >= 1; i--) {
            dp[0][i] = Math.max(dp[0][i+1],dp[1][i+1]);
            dp[1][i] = dp[0][i+1] + nums[i];
        }

        ret = Math.max(ret, Math.max(dp[0][1], dp[1][1]));

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        Solution213 s = new Solution213();
        System.out.println(s.rob(nums));
    }
}
