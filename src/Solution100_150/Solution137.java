package Solution100_150;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int tmp1 = 0, tmp2 = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp1 = ~tmp2 & (tmp1 ^ nums[i]);
            tmp2 = ~tmp1 & (tmp2 ^ nums[i]);
        }

        return tmp1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,3};
        Solution137 s = new Solution137();
        System.out.println(s.singleNumber(nums));
    }
}
