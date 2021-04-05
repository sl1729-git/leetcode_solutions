package Solution1_49;

import java.util.Arrays;

public class Solution34 {
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

    public int[] searchRange(int[] nums, int target) {
        int index = bsearch(nums, target, 0, nums.length);
        if (index == -1){
            return new int[]{-1,-1};
        }
        int left = index, right = index;
        while (left-1 >= 0){
            if (nums[left-1] != nums[left])
                break;
            left --;
        }
        while (right+1 < nums.length) {
            if (nums[right + 1] != nums[right])
                break;
            right ++;
        }
        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,6};
        Solution34 s = new Solution34();
        System.out.println(Arrays.toString(s.searchRange(nums,6)));
    }
}
