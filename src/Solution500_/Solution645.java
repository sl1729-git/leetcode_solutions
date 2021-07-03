package Solution500_;

import java.util.Arrays;

public class Solution645 {
    /**
     * 用的leetcode的额外空间的方式
     * @param nums 非空数组，元素是1-n，n为数组长度，其中只有一个元素重复
     * @return 如果输入是null，则返回null；如果满足输入条件，
     * 返回长度为2的数组，第一个为重复数，第二个为缺失数
     */
    public int[] findErrorNums(int[] nums) {
        if (nums == null)
            return null;

        int dup = -1, miss = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            miss ^= (i ^ num);
            if (nums[index] < 0)
                dup = num;
            else
                nums[index] *= -1;
        }
        miss ^= (dup ^ nums.length);
        return new int[]{dup, miss};
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        Solution645 s = new Solution645();
        System.out.println(s.findErrorNums(nums)[0] + " " + s.findErrorNums(nums)[1]);
    }
}
