package Solution1_49;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String tmp = String.valueOf(x);
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1))
                return false;
        }
        return true;
    }
}
