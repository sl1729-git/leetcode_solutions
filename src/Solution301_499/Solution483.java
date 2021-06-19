package Solution301_499;

public class Solution483 {

    /**
     * 此题直接看题解了，，，
     * @param n 需要大于3且小于10e18
     * @return 满足(111...1)_k的最小k
     */
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal)/Math.log(2));
        for (int i = mMax; i > 1; i--) {
            int k = (int)Math.pow(nVal, 1.0/i);
            long mul = 1, sum = 1;
            for (int j = 0; j < i; j++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal)
                return Integer.toString(k);
        }
        return Long.toString(nVal - 1);
    }

    public static void main(String[] args) {
        Solution483 s = new Solution483();
        System.out.println(s.smallestGoodBase("4681"));
    }
}
