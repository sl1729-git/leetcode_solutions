package Solution500_;

import java.util.Arrays;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] numCount = new int[2001];
        boolean[] countTime = new boolean[1002];
        Arrays.fill(numCount, -1);
        Arrays.fill(countTime, false);
        for (int i = 0; i < arr.length; i++) {
            numCount[arr[i]+1000]++;
        }
        for (int i = 0; i < numCount.length; i++) {
            if (countTime[numCount[i]<0?countTime.length-1:numCount[i]])
                return false;
            else
                countTime[numCount[i]<0?countTime.length-2:numCount[i]] = true;
        }
        return true;
    }
}
