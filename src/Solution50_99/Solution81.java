package Solution50_99;

public class Solution81 {
    private boolean bsearch(int[] nums, int target, int left, int right){
        if (left > right)
            return false;

        int mid = (left + right) >> 1;
        if (nums[mid] == target)
            return true;
        else if (nums[mid] > target)
            return bsearch(nums, target, mid + 1, right);
        else
            return bsearch(nums, target, left, mid - 1);
    }

    private int findK(int[] nums, int left, int right){
        if (left + 1 == right)
            return left + 1;
        int mid = (left + right) >> 1;
        if (nums[mid] < nums[right])
            return findK(nums, left, mid);
        else if (nums[mid] > nums[right])
            return findK(nums, mid, right);
        else {
            int try1 = findK(nums, left, mid) - 1;
            int try2 = findK(nums, mid, right) - 1;
            if (try1 == left && try2 == mid){
                if (nums[try1] < nums[try1 + 1])
                    return try2 + 1;
                else
                    return try1 + 1;
            }
            else if (try1 == left)
                return try2 + 1;
            else if (try2 == mid)
                return try1 + 1;
            else return try1;
        }
    }

    private boolean solutionWrong(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
//        if (nums.length < 16){
//            for (int i = 0; i < nums.length; i++) {
//                if (target == nums[i])
//                    return true;
//            }
//            return false;
//        }
        int k = findK(nums, 0, nums.length - 1);
        return bsearch(nums, target, 0, k) ||
                bsearch(nums, target, k + 1, nums.length - 1);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length < 8){
            for (int num : nums) {
                if (num == target)
                    return true;
            }
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[left] == nums[right] && nums[left] == nums[mid]){
                left ++;
                right --;
            }else if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else
                    left = mid + 1;
            }else {
                if (nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        Solution81 s = new Solution81();
        System.out.println(s.search(nums, 2));
    }
}
