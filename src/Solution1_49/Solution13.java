package Solution1_49;

import java.util.*;

public class Solution13 {
    public int romanToInt(String s) {
        int ret = 0;
        String[] tmp = {"IV","IX","XL","XC","CD","CM"};
        Set<String> cases = new HashSet<>(Arrays.asList(tmp));
        Map<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && cases.contains(s.substring(i,i+2))){
                ret -= valueMap.get(s.charAt(i));
                ret += valueMap.get(s.charAt(i+1));
                i++;
            }else {
                ret += valueMap.get(s.charAt(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution13 s13 = new Solution13();
        System.out.println(s13.romanToInt("IXII"));
    }
}
