package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1370 {


    public String sortString(String s) {
        List<int[]> list = new ArrayList<>();
        int[] charNum = new int[128];
        Arrays.fill(charNum, 0);
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i)]++;
        }
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i] != 0){
                list.add(new int[]{i,charNum[i]});
            }
        }

        StringBuffer ret = new StringBuffer();
        while (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                ret.append((char)list.get(i)[0]);
                if (--list.get(i)[1] == 0){
                    list.remove(i--);
                }
            }
            for (int i = list.size()-1; i >= 0; i--) {
                ret.append((char)list.get(i)[0]);
                if (--list.get(i)[1] == 0){
                    list.remove(i);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbccc";
        Solution1370 S = new Solution1370();
        System.out.println(S.sortString(s));
    }
}
