package Solution50_99;

import java.util.Arrays;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        if(n == 1 || m == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        Arrays.fill(dp[m-1],1);
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(3,7));
    }
}
