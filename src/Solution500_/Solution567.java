package Solution500_;

import java.util.Arrays;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length())
            return false;
        int[] charCountDiff = new int[26];
        boolean ret = false;
        for (int i = 0; i < s1.length(); i++) {
            charCountDiff[s1.charAt(i) - 'a'] ++;
            charCountDiff[s2.charAt(i) - 'a'] --;
        }
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            if (charCountDiff[s2.charAt(i) - 'a'] == 0) {
                ret = true;
                for (int countDiff:charCountDiff) ret &= (countDiff == 0);
                if (ret)
                    return ret;
            }
            charCountDiff[s2.charAt(i - s1.length() + 1) - 'a']++;
            if (i + 1 < s2.length())
                charCountDiff[s2.charAt(i + 1) - 'a']--;
        }

        return ret;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "ba";
        Solution567 s = new Solution567();
        System.out.println(s.checkInclusion(s1, s2));
    }
}
