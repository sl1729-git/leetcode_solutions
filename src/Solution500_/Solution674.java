package Solution500_;

public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = 1, currentMaxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                currentMaxLen ++;
            else {
                ret = Math.max(ret, currentMaxLen);
                currentMaxLen = 1;
            }
        }
        return Math.max(ret, currentMaxLen);
    }
}
