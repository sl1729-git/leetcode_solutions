package Solution500_;

import java.util.Arrays;

public class Solution1049 {
    /**
     * 这个也是伪动规，我们可以记a1,a2,a3,...,an为碎石顺序，则最后一块石头end为
     * end = an - (an-1 - (an-2 - ...) = an + (-1)^1*an-1 + ... + (-1)^(n-1)*a1
     * 显然，这些石头要么作为正数，要么作为负数，于是和494题一样了，只是这次我们要求最小的target
     * 那么我们记录dp[i]为迭代到某块石头后，我们是否存在一个石头的组合，其质量为i
     * 到迭代到最后一块石头后，如果有i为true，则就有end = sum - 2 * i的最后碎石的方式存在
     * @param stones 至少为正数的数组，数组和不能过大(sum(stones) < 1000)
     * @return 按照1049题所能做出的最小石块
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        boolean[] dp = new boolean[sum/2 + 1];
        dp[0] = true;
        for (int stone:stones) {
            for (int i = dp.length - 1; i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
        }

        int ret = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]){
                ret = sum - 2 * i;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{31,26,33,21,40};
        Solution1049 s = new Solution1049();
        System.out.println(s.lastStoneWeightII(stones));
    }
}
