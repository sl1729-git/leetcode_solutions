package Solution50_99;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ret = 0;
        if (obstacleGrid == null)
            return ret;
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[dp.length-1][dp[0].length-1] = 1;
        for (int i = dp.length-2; i >= 0; i--) {
            dp[i][dp[i].length-1] = obstacleGrid[i+1][dp[i].length-1] == 1 ? 0 :
                    dp[i+1][dp[i].length-1];
        }
        for (int i = dp[0].length-2; i >= 0; i--) {
            dp[dp.length-1][i] = obstacleGrid[dp.length-1][i+1] == 1 ? 0 :
                    dp[dp.length-1][i+1];
        }
        for (int i = obstacleGrid.length-2; i >= 0; i--) {
            for (int j = obstacleGrid[i].length-2; j >= 0; j--) {
                dp[i][j] = (obstacleGrid[i+1][j] == 1 ? 0 : dp[i+1][j]) +
                        (obstacleGrid[i][j+1] == 1 ? 0 : dp[i][j+1]);
            }
        }
        return obstacleGrid[dp.length-1][dp[0].length-1] == 1
                || obstacleGrid[0][0] == 1 ? 0 : dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Solution63 s = new Solution63();
        System.out.println(s.uniquePathsWithObstacles(grid));
    }
}
