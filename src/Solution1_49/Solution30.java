package Solution1_49;

import java.util.*;

public class Solution30 {
    private boolean check(int[] wordIndex, int wordLength, int index, int wordSetSize, Map<Integer, Integer> wordCount){
        boolean[] wordContain = new boolean[wordSetSize];
        Arrays.fill(wordContain, false);
        for (int i = 0; i < wordSetSize; i++) {
            int word = wordIndex[index + i * wordLength];
            if (word != -1){
                for (int j = 0; j < wordCount.get(word); j++) {
                    if (!wordContain[word + j]) {
                        wordContain[word + j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < wordContain.length; i++) {
            if (!wordContain[i])
                return false;
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || words == null || words.length == 0 ||s.length() < words.length * words[0].length())
            return ret;
        int[] wordIndex = new int[s.length()];
        Arrays.fill(wordIndex,-1);
        List<String> tmp = Arrays.asList(words);
        tmp.sort(String::compareTo);
        words = tmp.toArray(new String[0]);
        Map<String, Integer> wordMap = new HashMap<>();
        Map<Integer, Integer> wordCOunt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], wordMap.getOrDefault(words[i],i));
            wordCOunt.put(wordMap.get(words[i]),wordCOunt.getOrDefault(wordMap.get(words[i]),0)+1);
        }
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - words[0].length(); i++) {
            wordIndex[i] = wordMap.getOrDefault(s.substring(i,i+wordLength),-1);
        }
        int preCheck = 0;
        boolean checking = false;
        boolean[] wordChecked = new boolean[words.length];
        for (int i = 0; i <= wordIndex.length - words.length * words[0].length(); i++) {
            if (wordIndex[i] != -1 && check(wordIndex, words[0].length(), i, words.length, wordCOunt))
                ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        Solution30 s = new Solution30();
        System.out.println(s.findSubstring(S , words));
    }
}
