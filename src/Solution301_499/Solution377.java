package Solution301_499;

import java.util.Arrays;

public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        assert nums != null && target > 0;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num:nums) {
                if (num <= i)
                    dp[i] += dp[i - num];
                else
                    break;
            }
        }

        return dp[target];
    }
}
