package Solution50_99;

import java.util.*;

public class Solution76 {
    private class Pair{
        char aChar;
        int index;

        public Pair(char aChar, int index) {
            this.aChar = aChar;
            this.index = index;
        }
    }

    public String SolutionWrong(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCount.put(t.charAt(i), 0);
        }
        Pair[] pairs = new Pair[s.length()];
        int pairCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                pairs[pairCount++] = new Pair(s.charAt(i), i);
            }
        }
        int leftPoint = 0, rightPoint = 0, index = 0;
        boolean containAll = true;
        for (int i = 0; i < pairCount; i++) {
            if (charCount.get(pairs[i].aChar) == 0)
                charCount.put(pairs[i].aChar, 1);
            containAll = true;
            for (char key:charCount.keySet()) {
                if (charCount.get(key) == 0){
                    containAll = false;
                    break;
                }
            }
            if (containAll){
                rightPoint = i;
                break;
            }
        }
        if (!containAll)
            return "";
        String ret = s.substring(pairs[leftPoint].index, pairs[rightPoint].index+1);
//        charCount.put(pairs[rightPoint].aChar,charCount.get(pairs[rightPoint].aChar)-1);
        while (rightPoint < pairCount){
            charCount.put(pairs[leftPoint].aChar,charCount.get(pairs[leftPoint].aChar)-1);
            leftPoint ++;
            if (charCount.get(pairs[leftPoint-1].aChar) == 0){
                containAll = false;
                while (true){
                    rightPoint++;
                    if (rightPoint >= pairCount)
                        break;
                    charCount.put(pairs[rightPoint].aChar,charCount.get(pairs[rightPoint].aChar)+1);
                    if (pairs[leftPoint-1].aChar == pairs[rightPoint].aChar) {
                        containAll = true;
                        break;
                    }
                }
                if (containAll && pairs[rightPoint].index - pairs[leftPoint].index < ret.length())
                    ret = s.substring(pairs[leftPoint].index, pairs[rightPoint].index + 1);
            }else {
                if (pairs[rightPoint].index - pairs[leftPoint].index < ret.length())
                    ret = s.substring(pairs[leftPoint].index, pairs[rightPoint].index + 1);
            }
        }
        return ret;
    }

    private boolean containAll(Map<Character, Integer> charCount){
        for (Character c:charCount.keySet()) {
            if (charCount.get(c) > 0)
                return false;
        }
        return true;
    }


    public String minWindow(String s, String t) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = -1, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                charCount.put(s.charAt(i), charCount.get(s.charAt(i)) - 1);
                queue.add(new Pair(s.charAt(i), i));
            }
            if (left < 0 && charCount.containsKey(s.charAt(i)))
                left = i;
            if (containAll(charCount)) {
                right = i;
                break;
            }
        }

        String ret = s.substring(left, right + 1);
        for (int i = right + 1; i < s.length(); i++) {

        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "a", T = "b";
        Solution76 s = new Solution76();
        System.out.println(s.minWindow(S, T));
    }
}
