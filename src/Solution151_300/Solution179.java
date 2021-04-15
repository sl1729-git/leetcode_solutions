package Solution151_300;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public String largestNumber(int[] nums) {
        assert nums != null;
        if (nums.length == 0)
            return "0";
        boolean allZero = true;
        for (int value : nums) {
            allZero &= value == 0;
        }
        if (allZero)
            return "0";

        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (o1, o2) -> {
            String comb1 = o1 + o2;
            String comb2 = o2 + o1;
            return comb2.compareTo(comb1);
        });
        StringBuilder ret = new StringBuilder();
        for (String num:numsStr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String[] test = new String[]{"9","91","92","901"};
        Arrays.sort(test);
        System.out.println(Arrays.asList(test));
    }
}
