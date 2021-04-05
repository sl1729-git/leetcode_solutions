package Solution500_;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        assert cost != null && cost.length >= 2 && cost.length <= 1000;
        int ret = 0;
        int dp1 = 0, dp2 = 0, tmp = 0;
        for (int i = 2; i < cost.length; i++) {
            tmp = dp1;
            dp1 = Math.min(dp1+cost[i-1],dp2+cost[i-2]);
            dp2 = tmp;
        }
        return dp1;
    }
}
