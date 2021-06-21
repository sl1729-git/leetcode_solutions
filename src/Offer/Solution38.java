package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution38 {
    private void swap(char[] word, int i, int j){
        char tmp = word[i];
        word[i] = word[j];
        word[j] = tmp;
    }

    private void reverse(char[] word, int start){
        int left = start, right = word.length - 1;
        while (left < right)
            swap(word, left++, right--);
    }

    private boolean next(char[] word){
        int i = word.length - 2;
        while (i >= 0 && word[i] >= word[i + 1])
            i--;
        if (i >= 0){
            int j = word.length - 1;
            while (j >= 0 && word[i] >= word[j])
                j--;
            char tmp = word[i];
            word[i] = word[j];
            word[j] = tmp;
        }else
            return false;

        reverse(word, i + 1);
        return true;
    }

    /**
     * 每一次求下一个字符串，直到到达字典序最大的一个
     * @param s 要进行全排列的字符串s，不能为null
     * @return s的全排列，按照字典序由小到大排列
     */
    public String[] permutation(String s) {
        List<String> ret = new ArrayList<>();
        char[] currentWord = s.toCharArray();
        Arrays.sort(currentWord);
        do {
            ret.add(new String(currentWord));
        }while (next(currentWord));

        return ret.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution38 s = new Solution38();
        System.out.println(Arrays.asList(s.permutation("abc")));
    }
}
