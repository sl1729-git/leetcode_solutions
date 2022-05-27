package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        int ret = 0;
        if (nums == null || nums.length < 2)
            return ret;
        Map<Integer, Integer> preDiff = new HashMap<>();
        int sum = 0;
        preDiff.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = (i + 1 - 2 * sum);
            if (diff == 0) {
                ret = i + 1;
                continue;
            }
            if (preDiff.containsKey(diff)){
                ret = Math.max(ret, i - preDiff.get(diff));
            }else
                preDiff.put(diff, i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1};
        Solution525 s = new Solution525();
        System.out.println(s.findMaxLength(nums));
    }
}
