package Solution151_300;

public class Solution154 {
    public int findMin(int[] nums) {
        assert nums != null && nums.length > 0;
        int ret = Integer.MAX_VALUE;
        if (nums.length <= 8){
            for (int num:nums) {
                ret = Math.min(ret, num);
            }
            return ret;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]){
                left = mid;
            }else if (nums[mid] < nums[left]){
                right = mid;
            }else {
                left ++;
            }

            ret = Math.min(ret, nums[left]);
        }

        ret = Math.min(ret, Math.min(nums[left], nums[right]));

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1,1,1,1,1,1,1};
        Solution154 s = new Solution154();
        System.out.println(s.findMin(nums));
    }
}
