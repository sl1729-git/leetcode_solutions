package Solution500_;

public class Solution600 {
    private static int[] f = new int[32], g = new int[32], h = new int[32];

    static {
        f[0] = 1; g[0] = 0; h[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = h[i - 1];
            g[i] = f[i - 1];
            h[i] = f[i] + g[i];
        }
    }

    public int findIntegers(int n) {
        assert n >= 0;
        if (n == 0)
            return 1;
        int pre = 0;
        int ret = 0;
        for (int i = 29; i >= 0; i--) {
            int val = 1 << i;
            if ((n & val) == 0)
                pre = 0;
            else {
                ret += h[i];
                if (pre == 1)
                    break;
                pre = 1;
            }

            if (i == 0)
                ret++;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution600 s = new Solution600();
        System.out.println(s.findIntegers(5));
    }
}
