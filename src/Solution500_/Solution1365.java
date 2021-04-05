package Solution500_;

public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numCount = new int[101];
        int[] numCountBig = new int[101];
        for (int i = 0; i < nums.length; i++) {
            numCount[nums[i]] ++;
            numCountBig[nums[i]] ++;
        }
        for (int i = 1; i < numCount.length; i++) {
            numCountBig[i] += numCountBig[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numCountBig[nums[i]] - numCount[nums[i]];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};
        Solution1365 s = new Solution1365();
        System.out.println(s.smallerNumbersThanCurrent(nums)[0]);
    }
}
