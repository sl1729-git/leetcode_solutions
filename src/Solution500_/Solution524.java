package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution524 {
    private boolean findTheWord(String s, String word){
        char[] S = s.toCharArray(), wordChar = word.toCharArray();
        int index1 = 0, index2 = 0;
        while (index1 < S.length && index2 < wordChar.length){
            if (wordChar[index2] == S[index1])
                index2 ++;
            index1 ++;
        }

        return index2 == wordChar.length && wordChar[wordChar.length - 1] == S[--index1];
    }

    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0 || dictionary == null)
            return "";
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() != o2.length() ?
                        Integer.compare(o2.length(), o1.length()) :
                        o1.compareTo(o2);
            }
        });

        for (String word:dictionary) {
            if (findTheWord(s, word))
                return word;
        }

        return "";
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList("a","b","c","d"));
        String s = "abpcplea";
        Solution524 S = new Solution524();
        System.out.println(S.findLongestWord(s, dictionary));
    }
}
