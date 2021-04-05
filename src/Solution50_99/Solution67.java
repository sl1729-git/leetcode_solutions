package Solution50_99;

public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuffer ret = new StringBuffer();
        int len = a.length() < b.length() ? a.length() : b.length();
        boolean flag = false;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = a.charAt(a.length() - i - 1) + b.charAt(b.length() - i - 1) + (flag ? 1 : 0) - '0' * 2;
            flag = tmp >= 2;
            tmp = tmp == 3 || tmp == 1 ? 1 : 0;
            ret.append(tmp);
        }
        a = a.length() < b.length() ? b : a;
        for (int i = len; i < a.length(); i++) {
            tmp = a.charAt(a.length() - i - 1) + (flag ? 1 : 0) - '0';
            flag = tmp >= 2;
            tmp = tmp == 3 || tmp == 1 ? 1 : 0;
            ret.append(tmp);
        }
        if (flag)
            ret.append(1);
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67 s = new Solution67();
        System.out.println(s.addBinary("100","110010"));
    }
}
