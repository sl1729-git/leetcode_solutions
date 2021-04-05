package Competition;

public class Solution5541 {
    private int count(String s, String t){
        int ret = 0;
        for (int i = 0; i < t.length()-s.length()+1; i++) {
            int tmp = 0;
            for (int j = 0; j < s.length(); j++) {
                tmp += s.charAt(j) != t.charAt(i+j) ? 1 : 0;
                if (tmp > 1)
                    break;
            }
            ret += tmp == 1 ? 1 : 0;
        }
        return ret;
    }

    public int countSubstrings(String s, String t) {
        int ret = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length()-i+1; j++) {
                ret += count(s.substring(j,j+i),t);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "ab", t= "bb";
        Solution5541 solution = new Solution5541();
        System.out.println(solution.countSubstrings(s, t));
    }
}
