package Solution301_499;

import java.util.Arrays;

public class Solution494 {
    /**
     * 计sum为数组和，选出一些作为负数，这些数的绝对值和为neg，有result = sum - 2 * neg
     * 若result==target，则neg = (sum - target)/2，而由定义知neg是整数
     * 所以(sum - target)不为偶数则一定没有满足的方法
     *
     * 剩下的使用动态规划处理，也是伪动规
     * @param nums 一个仅包含非负数的数组
     * @param target 任意的数
     * @return 返回对数组填写正负号，使得填写后数组和为target的所有填写方法的数目
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int neg = sum - target;
        //如果不满足下式，则一定没有方法可以满足
        if ((neg & 1) != 0 || sum < Math.abs(target))
            return 0;

        //表示迭代到num时，dp[i]为包括num及之前的数组部分，抽选其和为i的方法数
        int[] dp = new int[neg / 2 + 1];
        dp[0] = 1;
        for (int num:nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();
        int[] nums = new int[]{1,0};
        System.out.println(s.findTargetSumWays(nums, 1));
    }
}
