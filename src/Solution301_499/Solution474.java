package Solution301_499;

public class Solution474 {
    /**
     * 伪动态规划解01背包问题，这里优化是最小化了动规的状态和更新的位置，将3维数组减为2维
     * @param strs 字符串数组，原则上只有字符‘0’与‘1’，实际会将所有非'0'字符视为1
     * @param m 允许的0的个数
     * @param n 允许的1的个数
     * @return 返回在允许m个0和n个1的前提下，在strs取最多多少个字符串
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]记录在当前迭代到第n个字符串下，有i个0和j个1的背包最多能装多少个字符串
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int count0 = 0, count1;
            char[] tmp = str.toCharArray();
            for (char c : tmp) {
                count0 += c == '0' ? 1 : 0;
            }
            count1 = tmp.length - count0;

            for (int j = m; j >= count0; j--) {
                for (int k = n; k >= count1; k--) {
                    dp[j][k] = Math.max(dp[j - count0][k - count1] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution474 s = new Solution474();
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(s.findMaxForm(strs, 5, 3));
    }
}
