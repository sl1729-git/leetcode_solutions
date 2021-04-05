package Solution1_49;

public class Solution33 {
    private int bsearch(int[] nums, int target, int left, int right){
        int index = (left+right)/2;
        if (index < right && nums[index] == target)
            return index;
        if (left+1 >= right)
            return -1;
        if (nums[index] > target)
            return bsearch(nums, target, left, index);
        else
            return bsearch(nums, target, index+1, right);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int ret = -1;
        int indexLeft = 0, indexRight = nums.length-1;
        int index = (indexLeft+indexRight)/2;
        int tmp;
        while (indexLeft+1 < indexRight){
            index = (indexLeft+indexRight)/2;
            if (nums[index] >=nums[0])
                indexLeft = index;
            else
                indexRight = index;
        }
        if (target < nums[nums.length-1] && target >= nums[indexRight])
            return bsearch(nums, target, indexRight, nums.length);
        else if (target >= nums[0] && target < nums[indexLeft]){
            return bsearch(nums, target, 0, indexLeft);
        }
        return (target == nums[nums.length-1] ? nums.length-1 : (target == nums[indexLeft] ? indexLeft : -1));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution33 s = new Solution33();
        System.out.println(s.search(nums,0));
    }
}
