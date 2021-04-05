package Solution50_99;

public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums == null)
            return false;
        int maxIndex = 0;
        for (int i = 0; i < nums.length && i <= maxIndex; i++) {
            maxIndex = (i + nums[i]) > maxIndex ? i + nums[i] : maxIndex;
        }
        return maxIndex >= nums.length - 1;
    }
}
