package Solution1_49;

public class Solution29 {
    public int divide(int dividend, int divisor) {
        boolean nagetive = ((dividend & 0x80000000) ^ (divisor & 0x80000000)) == 0x80000000;
        long dividendTmp = Math.abs((long) dividend);
        long divisorTmp  = Math.abs((long) divisor);
        long divisorTmp2 = divisorTmp;
        int shiftTime = 0;
        long ret = 0;
        while (divisorTmp < dividendTmp){
            divisorTmp = divisorTmp << 1;
            shiftTime ++;
        }
        while (dividendTmp >= divisorTmp2 && divisorTmp >= divisorTmp2){
            if (divisorTmp > dividendTmp){
                divisorTmp = divisorTmp >> 1;
                shiftTime --;
            }else{
                dividendTmp -= divisorTmp;
                ret |= ((long)1)<<shiftTime;
            }
        }
        return nagetive ? (int)-ret : ret>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ret;
    }

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        System.out.println(s.divide(Integer.MIN_VALUE,-1));
    }
}
