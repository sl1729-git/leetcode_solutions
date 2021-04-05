package Solution500_;

public class Solution509 {
    public int fib(int n) {
        assert n >= 0;
        int pre1 = 1, pre2 = -1, tmp;
        for (int i = 0; i <= n; i++) {
            tmp = pre1;
            pre1 = pre1 + pre2;
            pre2 = tmp;
        }
        return pre1;
    }
}
