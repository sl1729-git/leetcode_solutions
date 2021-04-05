public class Solution389 {
    public char findTheDifference(String s, String t) {
        assert s != null && t != null && s.length() + 1 == t.length();
        char ret = t.charAt(0);
        if (t.length() == 1)
            return ret;
        int[] charCount = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)] ++;
            charCount[t.charAt(i)] --;
        }
        charCount[t.charAt(t.length()-1)]--;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] == -1)
                return (char)i;
        }
        return (char)-1;
    }
}
