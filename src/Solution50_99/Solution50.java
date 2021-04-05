package Solution50_99;

public class Solution50 {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE){
            n = -(n/2);
            x = 1/(x*x);
        }
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        if(n == 1)
            return x;
        if (n == 0)
            return 1;
        return myPow(x * x, n/2) * (((n&1) == 1) ? x : 1);
    }

    public static void main(String[] args) {
        Solution50 s = new Solution50();
        System.out.println(s.myPow(34.00515,-3));
    }
}
