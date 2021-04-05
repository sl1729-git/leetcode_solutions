package Solution1_49;

public class Solution7 {
    public int reverse(int x) {
        if (x == 0){
            return 0;
        }
        int flag = x < 0 ? 1 : 0;
        boolean flag2 = true;
        String s = String.valueOf(x);
        StringBuffer tmp = new StringBuffer();
        if (x < 0){
            tmp.append("-");
        }
        for (int i = s.length() - 1; i >= flag ; i--) {
            if (flag2 && s.charAt(i) == '0'){
                continue;
            }else {
                flag2 = false;
                tmp.append(s.charAt(i));
            }
        }
        s = tmp.toString();
        long tmp2 = Long.decode(s);
        return (int)((tmp2 < 0) ? ((tmp2 < Integer.MIN_VALUE) ? 0 : tmp2) : ((tmp2 > Integer.MAX_VALUE) ? 0 : tmp2));
    }

    public static void main(String[] args) {
        int x = 901000;
        Solution7 s7 = new Solution7();
        s7.reverse(x);
    }
}
