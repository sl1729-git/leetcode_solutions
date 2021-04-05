package Solution50_99;

public class Solution70 {
    public int climbStairs(int n) {
        int ret = 0, pre = 1, tmp = -1;
        for (int i = 0; i <= n; i++) {
            tmp = ret;
            ret = ret + pre;
            pre = tmp;
        }
        return ret;
    }
}
