package Solution100_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] result = new int[numRows][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i+1];
            result[i][0] = 1;
            result[i][result[i].length-1] = 1;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j < result[i].length-1; j++) {
                result[i][j] = result[i-1][j] + result[i-1][j-1];
            }
        }
        for (int i = 0; i < result.length; i++) {
            ret.add(Arrays.stream(result[i-2]).boxed().collect(Collectors.toList()));
        }
        return ret;
    }
}
