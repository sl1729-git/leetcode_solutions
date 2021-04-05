package Solution1_49;

public class Solution38 {

    private String getNext(String s){
        assert s != null && s.length() > 0;
        char tmp = s.charAt(0);
        int num = 1;
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == tmp) num++;
            else {
                ret.append(num);
                ret.append(tmp);
                tmp = s.charAt(i);
                num = 1;
            }
        }
        ret.append(num);
        ret.append(tmp);
        return ret.toString();
    }

    public String countAndSay(int n) {
        String tmp = "1";
        for (int i = 0; i < n-1; i++) {
            tmp = getNext(tmp);
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution38 s = new Solution38();
        System.out.println(s.countAndSay(4));
    }
}
