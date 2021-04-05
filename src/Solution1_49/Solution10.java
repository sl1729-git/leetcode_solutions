package Solution1_49;

public class Solution10 {

    public boolean isMatch(String s, String p) {
        int s_index = 0;
        int p_index = 0;
        boolean ret = false;
        while (s_index < s.length() && p_index < p.length()){
            if (p_index+1 < p.length() && p.charAt(p_index+1) == '*'){
                if (s.charAt(s_index) == p.charAt(p_index) || p.charAt(p_index) == '.'){
                    ret |= isMatch(s.substring(s_index+1),p.substring(p_index));
                    if (ret)
                        return ret;
                }
                p_index += 2;
                continue;
            }
            if (p.charAt(p_index) == '.') {
                p_index++;
                s_index++;
            }else if (p.charAt(p_index) == s.charAt(s_index)){
                p_index++;
                s_index++;
            }else{
                return false;
            }
        }
        while (s_index == s.length() && p_index+1 < p.length() && p.charAt(p_index+1) == '*'){
            p_index += 2;
        }
        return s_index == s.length() && p_index == p.length();
    }

    public static void main(String[] args) {
        Solution10 s10 = new Solution10();
        String s = "a";
        String p = "ab*";
        boolean result = s10.isMatch(s,p);
        System.out.println(result);
    }
}
