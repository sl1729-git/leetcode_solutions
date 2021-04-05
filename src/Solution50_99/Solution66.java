package Solution50_99;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        assert digits != null;
        boolean allNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 9 || digits[i] < 0)
                throw new RuntimeException("Error input with digits bigger than 9 or smaller than 0");
            else if (digits[i] != 9)
                allNine = false;
        }
        if (allNine){
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        boolean flag = true;
        for (int i = digits.length-1; i >= 0 && flag; i--) {
            digits[i] = digits[i] + 1 > 9 ? 0 : digits[i] + 1;
            flag = digits[i] == 0;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1,1,9};
        Solution66 s = new Solution66();
        System.out.println(Arrays.stream(s.plusOne(digits)).boxed().collect(Collectors.toList()));
    }
}
