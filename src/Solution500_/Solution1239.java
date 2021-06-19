package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1239 {

    /**
     * 将字符串转为int的函数，其每一位都表示该位对于字母是否在字符串中
     * @param arr 字符串list，不为null
     * @return 返回转换后的int数组，如果输入字符串有重复字母的则会略过
     */
    private int[] legalString(List<String> arr){
        List<Integer> ret = new ArrayList<>();
        for (String str:arr) {
            int tmp = 0;
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                char currentChar = str.charAt(i);
                if (currentChar < 'a' || currentChar > 'z' || ((tmp >> (currentChar - 'a')) & 1) == 1) {
                    flag = false;
                    break;
                }
                tmp |= 1 << currentChar - 'a';
            }
            if (flag)
                ret.add(tmp);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 旧版迭代计算每一种情况的函数
     * @param arr 字符串数组，长度不超过20，并且所有字母均位小写字母
     * @return 返回字符串数组中的一个组合，使其每一个字母只出现一次的最长组合长度
     */
    public int solutionSlow(List<String> arr) {
        int[] arrInts = legalString(arr);
        if (arrInts.length > 20)
            return -1;
        int ret = 0;
        for (int currentCheck = 1 << arrInts.length;currentCheck >= 0;currentCheck--){
            int currentResult = 0;
            for (int i = 0; i < arrInts.length; i++) {
                if ((currentCheck & (1 << i)) != 0){
                    if ((currentResult ^ arrInts[i]) != (currentResult | arrInts[i])){
                        currentResult = 0;
                        break;
                    }
                    currentResult ^= arrInts[i];
                }
            }
            ret = Math.max(ret, Integer.bitCount(currentResult));
        }

        return ret;
    }

    /**
     * 新版迭代计算，这一次选择的方式是只计算符合要求的，快旧版一倍
     * @param arr 字符串数组，长度不超过20，并且所有字母均位小写字母
     * @return 返回字符串数组中的一个组合，使其每一个字母只出现一次的最长组合长度
     */
    public int maxLength(List<String> arr) {
        int[] arrInts = legalString(arr);
        if (arrInts.length > 20)
            return -1;
        int ret = 0;
        int[] ans = new int[1 << arrInts.length];
        int size = 1;
        for (int i = 0; i < arrInts.length; i++) {
            int currentInt = arrInts[i];
            int preSize = size;
            for (int j = 0; j < preSize; j++) {
                if ((currentInt & ans[j]) == 0) {
                    ans[size] = currentInt | ans[j];
                    ret = Math.max(ret, Integer.bitCount(ans[size++]));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String[] arr = {"cha","r","act","ers"};
        Solution1239 s = new Solution1239();
        System.out.println(s.maxLength(Arrays.asList(arr)));
    }
}
