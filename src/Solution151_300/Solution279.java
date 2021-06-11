package Solution151_300;

public class Solution279 {
    /**
     * 这一题也是动态规划可以解决，方式是维护一个dp的数组记录当前使用[sqrt*sqrt]中的数时
     * 需要的最少数量的数是多少，然后不断添加数到[sqrt*sqrt]当中，直到所有1到sqrt(n)的数
     * 均添加进去，则dp[n]就是答案
     *
     * 以及这个一开始容易考虑到贪心的方式，即每一次选一个最大的完全平方数，然后使用它，
     * 继续算n减去这个数后的下一个最大的完全平方数，这样是错误的，举例如下：
     * 41 = 5*5 + 4*4 = 6*6 + 2*2 + 1*1，显然最右侧就是贪心的结果，并不正确
     *
     * @param n 一个大于0的正整数，若小于0则会抛出错误
     * @return n >= 1时返回最小需要的完全平方数的数量，n == 0返回0，
     */
    public int numSquares(int n) {
        assert n > 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int sqrt = (int)Math.floor(Math.sqrt(n));
        for (int i = sqrt; i >= 2; i--) {
            int current = i * i;
            for (int j = current; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - current] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        Solution279 s = new Solution279();
        System.out.println(s.numSquares(n));
    }
}
