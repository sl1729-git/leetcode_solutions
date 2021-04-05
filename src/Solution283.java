public class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++,index++){
            nums[index] = nums[i];
            index -= nums[index] == 0 ? 1 : 0;
        }
        for (int i = index; i < nums.length; i++) nums[i] = 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        Solution283 s = new Solution283();
        s.moveZeroes(nums);
    }
}
