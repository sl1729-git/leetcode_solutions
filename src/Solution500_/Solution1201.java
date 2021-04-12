package Solution500_;

public class Solution1201 {

    private long getMCM(long a, long b){
        long ret = a * b;
        long tmp;
        while (b > 0){
            tmp = a % b;
            a = b;
            b = tmp;
        }

        return ret/a;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        assert n > 0;
        int p1 = 1, p2 = 1, p3 = 1;
        long abMCM = getMCM(a, b);
        long acMCM = getMCM(a, c);
        long bcMCM = getMCM(b, c);
        long abcMCM = getMCM(abMCM, c);
        int ret = 0;
        for (int i = 30; i >= 0; i--) {
            int test = ret | (1 << i);
            int testIndex = (int) (test/a + test/b + test/c -
                    test/abMCM - test/acMCM - test/bcMCM + test/abcMCM);
            if (testIndex <= n)
                ret |= (1 << i);

            if (testIndex == n)
                break;
        }

        return ret;
    }

    public static void main(String[] args) {
        int n = 4, a = 2, b = 3, c = 4;
        Solution1201 s = new Solution1201();
        System.out.println(s.nthUglyNumber(n, a, b, c));
    }
}
