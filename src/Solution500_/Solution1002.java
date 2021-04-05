package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1002 {

    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        int[] currentStrCharCount = new int[26];
        int[] globalStrCharCount  = new int[26];
        Arrays.fill(globalStrCharCount,Integer.MAX_VALUE);
        Arrays.fill(currentStrCharCount,0);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                int index = A[i].charAt(j)-'a';
                currentStrCharCount[index] ++;
            }
            for (int j = 0; j < 26; j++) {
                globalStrCharCount[j] = globalStrCharCount[j] < currentStrCharCount[j] ? globalStrCharCount[j] : currentStrCharCount[j];
            }
            Arrays.fill(currentStrCharCount,0);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < globalStrCharCount[i]; j++) {
                ret.add(String.valueOf((char) (i+'a')));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1002 s = new Solution1002();
        String[] A = new String[]{"bella","hello","roller"};
        System.out.println(s.commonChars(A));
    }

}
