package Solution151_300;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null || pattern.length() != s.split(" ").length)
            return false;
        String[] words = s.split(" ");
        int caseCount = 0;
        Map<String, Character> word2int = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if ((!word2int.containsKey(words[i])) &&
                    (!word2int.containsValue(pattern.charAt(i)))){
                word2int.put(words[i], pattern.charAt(i));
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (pattern.charAt(i) != word2int.getOrDefault(words[i],' '))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "dog cat cat fish";
        Solution290 s = new Solution290();
        System.out.println(s.wordPattern("abba",S));
    }
}
