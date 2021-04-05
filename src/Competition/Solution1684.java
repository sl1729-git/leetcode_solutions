package Competition;

public class Solution1684 {

    private boolean check(int[] charSet, String word){
        for (int i = 0; i < word.length(); i++) {
            if (charSet[word.charAt(i) & 0xff] != 1)
                return false;
        }
        return true;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int[] charSet = new int[256];
        for (int i = 0; i < allowed.length(); i++) {
            charSet[allowed.charAt(i) & 0xff] = 1;
        }

        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            ret += check(charSet, words[i]) ? 1 : 0;
        }
        return ret;
    }
}
