import java.util.Arrays;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        assert s != null && t != null && s.length() == t.length();
        char[] charMap = new char[256];
        boolean[] charUse = new boolean[256];
        Arrays.fill(charMap,(char)-1);
        Arrays.fill(charUse, false);
        for (int i = 0; i < s.length(); i++) {
            if (charMap[s.charAt(i)] == (char)-1) {
                if (charUse[t.charAt(i) & 0x7f])
                    return false;
                charUse[t.charAt(i) & 0x7f] = true;
                charMap[s.charAt(i)] = (char)(t.charAt(i) & 0x7f);
            }
            else if (charMap[s.charAt(i)] != (t.charAt(i) & 0x7f))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 s = new Solution205();
        System.out.println(s.isIsomorphic("afd","egg"));
    }
}
