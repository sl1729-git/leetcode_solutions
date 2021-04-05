package Solution500_;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1178 {

    private int strCharContain(String str){
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            ret |= (1 << (str.charAt(i) - 'a'));
        }

        return ret;
    }

    private boolean checkAnsForAPuzzle(int word, int puzzle){
        return ((word & puzzle) ^ word) == 0;
    }

    private void checkAnsForPuzzles(int word, int[] puzzles, int[][] puzzlesFirstCharIndexPair,
                                    int[] puzzlesFirstCharIndexPairSize, int[] Ans){
        for (int i = 0; i < 26; i++) {
            if ((word & (1 << i)) != 0){
                for (int j = 0; j < puzzlesFirstCharIndexPairSize[i]; j++) {
                    int index = puzzlesFirstCharIndexPair[i][j];
                    Ans[index] += checkAnsForAPuzzle(word, puzzles[index]) ? 1 : 0;
                }
            }
        }
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] wordCharContain = new int[words.length];
        int[] puzzlesCharContain = new int[puzzles.length];
        for (int i = 0; i < words.length; i++) {
            wordCharContain[i] = strCharContain(words[i]);
        }
        for (int i = 0; i < puzzles.length; i++) {
            puzzlesCharContain[i] = strCharContain(puzzles[i]);
        }

        int[][] puzzlesFirstCharIndexPair = new int[26][puzzles.length];
        int[] puzzlesFirstCharIndexPairSize = new int[26];
        for (int i = 0; i < puzzles.length; i++) {
            int charIndex = puzzles[i].charAt(0) - 'a';
            puzzlesFirstCharIndexPair[charIndex][puzzlesFirstCharIndexPairSize[charIndex]++] = i;
        }

        int[] puzzleAnsCount = new int[puzzles.length];
        for (int i = 0; i < wordCharContain.length; i++) {
            checkAnsForPuzzles(wordCharContain[i], puzzlesCharContain, puzzlesFirstCharIndexPair,
                    puzzlesFirstCharIndexPairSize, puzzleAnsCount);
        }

        return Arrays.stream(puzzleAnsCount).boxed().collect(Collectors.toList());
    }
}
