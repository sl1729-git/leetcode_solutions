package Solution1_49;

import java.util.*;

public class Solution17 {
    private Map<Character,String> wordMap = new HashMap<>();
    {
        wordMap.put('2',"abc");
        wordMap.put('3',"def");
        wordMap.put('4',"ghi");
        wordMap.put('5',"jkl");
        wordMap.put('6',"mno");
        wordMap.put('7',"pqrs");
        wordMap.put('8',"tuv");
        wordMap.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0)
            return ret;
        int[] indexs = new int[digits.length()];
        int[] indexsMax = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            indexsMax[i] = wordMap.get(digits.charAt(i)).length();
        }
        indexsMax[0]++;
        Arrays.fill(indexs,0);
        int headMaxIndex = wordMap.get(digits.charAt(0)).length();
        StringBuffer tmp = new StringBuffer();
        while (indexs[0] < headMaxIndex){
            for (int i = 0; i < indexs.length; i++) {
                tmp.append(wordMap.get(digits.charAt(i)).charAt(indexs[i]));
            }
            ret.add(tmp.toString());
            tmp.delete(0,tmp.length());
            int tmpIndex = indexs.length - 1;
            for (int i = indexs.length-1; i >= 0 ; i--) {
                indexs[i] ++;
                if (indexs[i] < indexsMax[i]){
                    break;
                }
                else{
                    indexs[i] = 0;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations("23"));
    }
}
