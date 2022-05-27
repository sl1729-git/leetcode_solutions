package Solution301_499;

public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        int ret = 0;
        if (nums == null || nums.length <= 1)
            return ret;

        int[] bit1Count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit1Count[j] += (nums[i] >> j) & 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            ret += bit1Count[i] * (nums.length - bit1Count[i]);
        }

        return ret;
    }
}
