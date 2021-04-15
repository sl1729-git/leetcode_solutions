package Solution301_499;

public class Solution387 {
    public int firstUniqChar(String s) {
        char[] charCount = new char[256];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)&0xff]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i)&0xff] == 1)
                return i;
        }
        return -1;
    }
}
