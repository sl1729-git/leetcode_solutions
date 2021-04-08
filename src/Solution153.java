public class Solution153 {


    private int findMin(int[] nums, int left, int right){
        int mid = (left + right) / 2;

        if (left + 1 >= right)
            return Math.min(nums[left], nums[left + 1]);
        if (nums[mid] < nums[right]){
            return findMin(nums, left, mid);
        }else
            return findMin(nums, mid, right);
    }

    public int findMin(int[] nums) {
        assert nums != null && nums.length > 0;

        int ret = Integer.MAX_VALUE;
        if (nums.length < 8){
            for (int num : nums) {
                ret = Math.min(ret, num);
            }
        }else
            ret = findMin(nums, 0, nums.length - 1);

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,1,2,3,4,5,6};
        Solution153 s = new Solution153();
        System.out.println(s.findMin(nums));
    }
}
