package Solution151_300;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {

    private void put(int[] nums, int start, int end, List<String> ret){
        if (start == end){
            ret.add(String.valueOf(nums[end]));
        }else
            ret.add(String.format("%d->%d", nums[start], nums[end]));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ret;
        int start = 0, end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1){
                end = i - 1;
                put(nums, start, end, ret);
                start = i;
            }
        }
        if (end != nums.length - 1)
            put(nums, start, nums.length - 1, ret);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        Solution228 s = new Solution228();
        System.out.println(s.summaryRanges(nums));
    }
}
