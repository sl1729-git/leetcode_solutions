package Solution500_;

public class Solution810 {
    public boolean xorGame(int[] nums) {
        if (nums == null || nums.length % 2 == 0)
            return true;
        int ret = 0;
        for (int num:nums)
            ret ^= num;
        return ret == 0;
    }
}
