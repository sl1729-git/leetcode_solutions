package Solution301_499;

import java.util.Arrays;

public class Solution330 {

    private void fill(int[] nums, boolean[] ans){
        ans[0] = true;
        int max = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
            len = max < ans.length - 1 ? max : ans.length - 1;
            for (int j = nums[i]; j <= len; j++) {
                ans[j] |= ans[j-nums[i]];
            }
        }
    }

    public int solutionBad(int[] nums, int n) {
        assert n >= 0;
        if (n == 0)
            return 0;
        boolean[] hasFull = new boolean[n+1];
        Arrays.fill(hasFull, false);
        fill(nums, hasFull);
        int index = 1;
        int ret = 0;
        while (index <= n){
            if (!hasFull[index]){
                for (int i = hasFull.length - 1; i >= index; i--) {
                    hasFull[i] |= hasFull[i-index];
                }
                ret ++;
            }
            index ++;
        }
        return ret;
    }

    public int minPatches(int[] nums, int n) {
        long currentMaxFill = 1;
        long max = n;
        int index = 0;
        int ret = 0;

        while (currentMaxFill <= max){
            if (index < nums.length && nums[index] <= currentMaxFill){
                currentMaxFill += nums[index++];
            }else {
                currentMaxFill = currentMaxFill * 2;
                ret ++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,31,33};
        Solution330 s = new Solution330();
        System.out.println(s.minPatches(nums,Integer.MAX_VALUE));
    }
}
