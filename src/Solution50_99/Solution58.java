package Solution50_99;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length > 0 ? words[words.length-1].length() : 0;
    }
}
