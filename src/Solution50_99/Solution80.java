package Solution50_99;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        assert nums != null;
        if (nums.length <= 2)
            return nums.length;
        int ret = 0, index = 1, preNum = nums[0], count = 1;
        for (; index < nums.length; index++) {
            count = preNum == nums[index] ? count+1 : 1;
            ret += count <= 2 ? 1 : 0;
            preNum = nums[index];
            if (count <= 2)
                nums[ret] = nums[index];
        }

        return ret + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        Solution80 s = new Solution80();
        s.removeDuplicates(nums);
    }
}
