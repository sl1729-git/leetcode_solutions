package Solution500_;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int ret = 0;
        int maxBefore = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                ret ++;
                if (nums[i] < maxBefore || ((i + 1) < nums.length && nums[i+1] < nums[i-1]))
                    return false;
            }
            maxBefore = Math.max(maxBefore, nums[i-1]);
        }
        return ret <= 1;
    }
}
