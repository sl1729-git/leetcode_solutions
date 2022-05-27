package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    /**
     * 这个比暴力的慢应该是测试集的问题
     * @param nums 输入待检测的数组
     * @param k 输入求和的目标
     * @return true,如果存在一个长度至少为2的子数组使得其和为k的倍数，false，对于其他情况
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        preSumIndex.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = (currentSum + nums[i]) % k;
            if (preSumIndex.containsKey(currentSum)){
                if (i - preSumIndex.get(currentSum) >= 2)
                    return true;
            }else
                preSumIndex.put(currentSum, i);
        }

        return false;
    }
}
