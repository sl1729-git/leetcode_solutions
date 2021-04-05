package Solution500_;

public class Solution844 {

    private String cleanBackspace(String S){
        StringBuffer buf = new StringBuffer();
        char tmp;
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            tmp = S.charAt(i);
            if (tmp == '#' && len > 0){
                len --;
                buf.delete(len, len+1);
            }else if (tmp != '#'){
                len ++;
                buf.append(tmp);
            }
        }
        return buf.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        S = cleanBackspace(S);
        T = cleanBackspace(T);
        return S.equals(T);
    }

    public static void main(String[] args) {
        String S = "##c", T = "#ad####dc";
        Solution844 s = new Solution844();
        System.out.println(s.backspaceCompare(S, T));
    }
}
