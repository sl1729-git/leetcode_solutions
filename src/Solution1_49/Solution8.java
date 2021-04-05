package Solution1_49;

public class Solution8 {
    public int myAtoi(String s) {
        int index = -1;
        long ret = 0;
        boolean flag = true,flag2 = false, flag3 = true;
        while(index+1 < s.length()){
            index ++;
            if (s.charAt(index) == ' ' && flag)
                continue;
            flag = false;
            if (s.charAt(index) == '-' && flag3) {
                flag2 = true;
                flag3 = false;
                continue;
            }else if (s.charAt(index) == '+' && flag3) {
                flag3 = false;
                continue;
            }
            int tmp = s.charAt(index) - '0';
            if (tmp > 10 || tmp  < 0)
                break;
            flag3 = false;
            ret *= 10;
            ret += tmp;
            if (ret-1 > Integer.MAX_VALUE)
                return flag2 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int)(flag2 ? -1 * ret : ret);
    }

    public static void main(String[] args) {
        Solution8 s8 = new Solution8();
        System.out.println(s8.myAtoi("-91283472332"));
    }
}
