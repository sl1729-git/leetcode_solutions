package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        if (S.length() == 0){
            return ret;
        }
        int currentMaxIndex = 0, currentMinIndex = 0;
        int[] charMaxIndex = new int[26];
        Arrays.fill(charMaxIndex, 0);
        for (int i = 0; i < S.length(); i++) {
            charMaxIndex[S.charAt(i) - 'a'] = i;
        }
        while (currentMinIndex < S.length()){
            currentMaxIndex = charMaxIndex[S.charAt(currentMinIndex) - 'a'];
            for (int i = currentMinIndex; i <= currentMaxIndex; i++) {
                currentMaxIndex = currentMaxIndex < charMaxIndex[S.charAt(i) - 'a'] ?
                        charMaxIndex[S.charAt(i) - 'a'] : currentMaxIndex;
            }
            ret.add(currentMaxIndex-currentMinIndex+1);
            currentMinIndex = currentMaxIndex + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "aba";
        Solution763 s = new Solution763();
        System.out.println(s.partitionLabels(S));
    }
}
