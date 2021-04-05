package Solution1_49;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer,Integer> tmp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.put(nums[i],i);
            nums[i] = target - nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.keySet().contains(nums[i]) && (tmp.get(nums[i]) != i)){
                ret[0] = i;
                ret[1] = tmp.get(nums[i]);
                break;
            }
        }
        return ret;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int checkNum = target - nums[i];
            if (tmp.containsKey(checkNum)){
                return new int[] {i,tmp.get(checkNum)};
            }
            tmp.put(nums[i],i);
        }
        throw new IllegalArgumentException("No solution\r\n");
    }


}
