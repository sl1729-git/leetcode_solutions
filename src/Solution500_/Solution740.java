package Solution500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int ret = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num:nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int[] numSorted = numCount.keySet().stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(numSorted);

        int[][] dp = new int[2][numSorted.length];
        int preNum = numSorted[0];
        dp[0][0] = preNum * numCount.get(preNum);
        for (int i = 1; i < numSorted.length; i++) {
            int currentNum = numSorted[i];
            int currentNumCount = numCount.get(currentNum);
            int value = currentNum * currentNumCount;
            dp[0][i] = currentNum != (preNum + 1) ? dp[0][i - 1] + value :
                    Math.max(dp[0][i - 1], dp[1][i - 1] + value);
            dp[1][i] = dp[0][i-1];
            preNum = currentNum;
        }

        ret = Math.max(dp[0][numSorted.length - 1], dp[1][numSorted.length - 1]);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,4,5,5,5,6};
        Solution740 s = new Solution740();
        System.out.println(s.deleteAndEarn(nums));
    }
}
