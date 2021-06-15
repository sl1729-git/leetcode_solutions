package Solution151_300;

public class Solution162 {
    /**
     *
     * @param nums 一个可能含有峰的数组
     * @return 如果nums为null或没有峰，返回-1，否则返回其中一个峰的索引，
     * 这里假设nums[0]和nums[nums.length]为负无穷
     */
    public int findPeakElement(int[] nums) {
        int ret = 0;
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return ret;
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = (right + left) / 2;
            if (nums[mid] <= nums[mid + 1]) {
                ret = mid + 1;
                left = ret;
            }
            else
                right = mid;
        }

        return ret == nums.length - 1 && nums[ret] <= nums[ret-1] ? -1 : ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        Solution162 s = new Solution162();
        System.out.println(s.findPeakElement(nums));
    }
}
