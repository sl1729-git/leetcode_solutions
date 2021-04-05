package Solution500_;

import java.util.Arrays;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int subListSum = 0, maxSubListSum = Integer.MIN_VALUE;
        for (int i = 0; i < k - 1; i++) subListSum += nums[i];
        for (int i = k - 1; i < nums.length; i++) {
            subListSum += nums[i];
            maxSubListSum = (maxSubListSum < subListSum) ? subListSum : maxSubListSum;
            subListSum -= nums[i-k+1];
        }
        return (double)maxSubListSum / k;
    }
}
