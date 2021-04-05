package Solution100_150;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        assert rowIndex >= 0;
        int[] aRow = new int[rowIndex + 1];
        int pre = 0;
        aRow[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            pre = 1;
            for (int j = 1; j < i; j++) {
                aRow[j] = pre + aRow[j];
                pre = aRow[j] - pre;
            }
            aRow[i] = 1;
        }

        return Arrays.stream(aRow).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution119 s = new Solution119();
        System.out.println(s.getRow(3));
    }
}
