public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int currentCount = 0;
        for (int num:nums) {
            if (num == 1)
                currentCount ++;
            else {
                ret = Math.max(ret, currentCount);
                currentCount = 0;
            }
        }
        ret = Math.max(ret, currentCount);
        return ret;
    }
}
