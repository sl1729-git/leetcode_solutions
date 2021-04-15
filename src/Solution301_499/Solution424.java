package Solution301_499;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int ret = 0;
        int left = 0, right = 0;
        int currentUse = 0;
        int[] charCount = new int[26];
        while (right < s.length()){
            int step = k - currentUse, maxCharUse = 0;
            step = (step + right) < s.length() ? step : s.length() - right;
            for (int i = 0; i < step; i++) {
                charCount[s.charAt(right) - 'A']++;
                right ++;
            }

            for (int i = 0; i < charCount.length; i++) {
                maxCharUse = maxCharUse < charCount[i] ? charCount[i] : maxCharUse;
            }
            currentUse = right - left - maxCharUse;
            while (right < s.length() && charCount[s.charAt(right) - 'A'] == maxCharUse){
                maxCharUse ++;
                charCount[s.charAt(right++) - 'A'] ++;
            }
            ret = ret < (right - left) ? right - left : ret;
            if (currentUse == k)
                charCount[s.charAt(left++) - 'A'] --;
        }

        return ret;
    }
}
