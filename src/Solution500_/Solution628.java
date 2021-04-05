package Solution500_;

import java.util.Arrays;

public class Solution628 {
    private void add(int[] nums, int num, boolean getMax){
        int index, tmp;
        if ((getMax && nums[0] > num) || (!getMax && nums[0] < num))
            return;
        if (getMax){
            for (index = 0; index < nums.length; index++) {
                if (nums[index] >= num) {
                    break;
                }
            }
        }else {
            for (index = 0; index < nums.length; index++)
                if (nums[index] <= num){
                    break;
                }
        }
        for (int i = index - 1; i >= 0; i--) {
            tmp = nums[i];
            nums[i] = num;
            num = tmp;
        }
    }

    public int maximumProduct(int[] nums) {
        int[] min = new int[2], max = new int[3];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            add(max, nums[i], true);
            add(min, nums[i], false);
        }
        return Math.max(max[0]*max[1]*max[2], max[2]*min[0]*min[1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100,-2,-3,1};
        Solution628 s = new Solution628();
        System.out.println(s.maximumProduct(nums));
    }
}
