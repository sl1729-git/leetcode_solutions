package Solution100_150;

import java.util.Arrays;

public class Solution125 {
    private boolean[] quickCheck = new boolean[256];

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;
        Arrays.fill(quickCheck, false);
        for (int i = 'a'; i <= 'z'; i++) {
            quickCheck[i] = true;
        }
        for (int i = '0'; i <= '9'; i++) {
            quickCheck[i] = true;
        }
        int left = 0, right = s.length() - 1;;
        s = s.toLowerCase();
        while (left <= right){
            while (left <= right && !quickCheck[s.charAt(left) & 0xff])left++;
            while (left <= right && !quickCheck[s.charAt(right) & 0xff])right--;
            if (left <= right && s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
