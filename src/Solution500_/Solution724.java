package Solution500_;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0;
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length <= 1)
            return nums.length;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right)
                return i;
            left += nums[i];
            right -= nums[i+1];
        }

        return left == right ? nums.length - 1 : -1;
    }
}
