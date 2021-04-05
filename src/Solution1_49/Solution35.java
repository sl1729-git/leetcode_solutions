package Solution1_49;

public class Solution35 {
    private int bsearch(int[] nums, int target, int left, int right){
        int index = (left+right)/2;
        if (index < right && nums[index] == target)
            return index;
        if (left+1 >= right)
            return left;
        if (nums[index] > target)
            return bsearch(nums, target, left, index);
        else
            return bsearch(nums, target, index+1, right);
    }

    public int searchInsert(int[] nums, int target) {
        int ret = bsearch(nums, target, 0, nums.length);
        ret -= ret == nums.length ? 1 :0;
        if (nums[ret] == target)
            return ret;
        return nums[ret] > target ? ret : ret + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        Solution35 s = new Solution35();
        System.out.println(s.searchInsert(nums,4));
    }
}
