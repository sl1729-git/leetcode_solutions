package Solution151_300;

import java.util.Arrays;

public class Solution238 {
    /**
     * 我直接好家伙，最快是作弊搞出的成绩，这个不使用除法
     * 应该是最快了。
     * @param nums 输入的数组，不为null，且长度大于0，
     *             并且乘积和小于int最大值
     * @return 数组内元素乘积和除以其自身的值
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int[] ret = new int[nums.length];
        Arrays.fill(ret, 1);
        int tmp = 1;
        for (int i = 0; i < ret.length; i++) {
            ret[i] *= tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] *= tmp;
            tmp *= nums[i];
        }

        return ret;
    }
}
