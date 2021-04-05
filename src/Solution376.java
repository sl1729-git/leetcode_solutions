public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = 1;
        int diff = 0, preDiff = 0, currentNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff = nums[i] - currentNum;
            if (diff == 0)
                continue;
            if (diff < 0 && preDiff >= 0){
                ret ++;
                currentNum = nums[i];
            }else if (diff > 0 && preDiff <= 0){
                ret ++;
                currentNum = nums[i];
            }else {
                currentNum = nums[i];
            }
            preDiff = diff;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        Solution376 s = new Solution376();
        System.out.println(s.wiggleMaxLength(nums));
    }
}
