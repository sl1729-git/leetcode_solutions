package Solution50_99;

import java.util.Arrays;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        assert grid != null && grid.length > 0 && grid[0].length > 0;
        int[] dp = Arrays.copyOf(grid[0], grid[0].length);
        for (int i = 1; i < dp.length; i++)
            dp[i] += dp[i-1];
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < dp.length; j++)
                dp[j] = Math.min(dp[j] + grid[i][j], dp[j-1] + grid[i][j]);
        }
        return dp[dp.length-1];
    }
}
