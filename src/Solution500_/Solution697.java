package Solution500_;

import java.util.ArrayList;
import java.util.List;

public class Solution697 {
    private static int MAX_NUM= 50000;

    public int findShortestSubArray(int[] nums) {
        int[] numCount = new int[MAX_NUM];
        int[] firstIndex = new int[MAX_NUM];
        int[] lastIndex = new int[MAX_NUM];
        int maxCount = 0, ret = MAX_NUM;
        for (int i = 0; i < nums.length; i++) {
            maxCount = Math.max(maxCount,++ numCount[nums[i]]);
            if (numCount[nums[i]] == 1) {
                firstIndex[nums[i]] = i;
                lastIndex[nums[i]] = i;
            }
            else
                lastIndex[nums[i]] = i;
        }

        for (int i = 0; i < MAX_NUM; i++) {
            if (numCount[i] == maxCount)
                ret = Math.min(ret, lastIndex[i] - firstIndex[i]);
        }
        return ret + 1;
    }
}
