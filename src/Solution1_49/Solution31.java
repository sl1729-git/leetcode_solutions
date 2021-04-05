package Solution1_49;

public class Solution31 {
    public void swap(int[] nums, int i, int j){
        assert i < nums.length && j < nums.length;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int index){
        for (int i = index; i < (nums.length + index)/2; i++) {
            swap(nums, i, nums.length-(i-index)-1);
        }
    }

    public void nextPermutation(int[] nums) {
        boolean changed = false;
        int tmp;
        int indexStart = 0, indexEnd = nums.length-1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]){
                indexStart = i-1;
                indexEnd   = i;
                tmp = nums[i-1];
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] <= nums[indexEnd]) {
                        indexEnd = j;
                    }
                }
                changed = true;
                break;
            }
        }
        if (changed){
            swap(nums, indexStart++, indexEnd);
        }
        reverse(nums, indexStart);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution31 s = new Solution31();
        s.nextPermutation(nums);
        s.nextPermutation(nums);
        s.nextPermutation(nums);
        s.nextPermutation(nums);
        s.nextPermutation(nums);
        s.nextPermutation(nums);
        s.nextPermutation(nums);
    }

}
