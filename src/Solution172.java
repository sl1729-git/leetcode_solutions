public class Solution172 {
    public int badSolution(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 != 0)
                continue;
            int tmp = i;
            while (tmp % 5 == 0){
                ret ++;
                tmp /= 5;
            }
        }
        return ret;
    }

    public int trailingZeroes(int n) {
        int ret = 0;
        while (n > 0){
            n /= 5;
            ret += n;
        }
        return ret;
    }
}
