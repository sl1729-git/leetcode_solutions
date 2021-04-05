package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution977 {
    public int[] sortedSquares(int[] A) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            ret.add(A[i]*A[i]);
        }
        ret.sort(Integer::compareTo);
        for (int i = 0; i < A.length; i++) {
            A[i] = ret.get(i);
        }
        return A;
    }
}
