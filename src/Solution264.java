import java.util.PriorityQueue;
import java.util.Queue;

public class Solution264 {
    public int nthUglyNumber(int n) {
        assert n > 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int pointer2 = 0, pointer3 = 0, pointer5 = 0;
        for (int i = 1; i < n; i++) {
            int tmp1 = dp[pointer2] * 2;
            int tmp2 = dp[pointer3] * 3;
            int tmp3 = dp[pointer5] * 5;
            dp[i] = Math.min(Math.min(tmp1, tmp2), tmp3);
            if (dp[i] == tmp1)
                pointer2 ++;
            if (dp[i] == tmp2)
                pointer3 ++;
            if (dp[i] == tmp3)
                pointer5 ++;
        }
        return dp[dp.length-1];
    }
}
