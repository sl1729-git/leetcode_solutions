package Solution1_49;

public class Solution45 {

    private int findMin(int[] nums, int start, int len){
        len = (start+len+1 > nums.length) ? nums.length : start+len+1;
        int ret = Integer.MAX_VALUE-1;
        for (int i = start+1; i < len; i++) {
            ret = (ret > nums[i]) ? nums[i] : ret;
        }
        return ret;
    }

    public int jump(int[] nums) {
        int[] jumpTimes = new int[nums.length];
        jumpTimes[jumpTimes.length-1] = 0;
        for (int i = jumpTimes.length-2; i >= 0; i--) {
            jumpTimes[i] = findMin(jumpTimes, i, nums[i]) + 1;
        }
        return jumpTimes[0];
    }

    public static void main(String[] args) {
        Solution45 s = new Solution45();
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(s.jump(nums));
    }
}
