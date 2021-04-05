package Solution500_;

import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = 2 * tmp + A[i];
            tmp = tmp % 5;
            ret.add(tmp == 0);
        }
        return ret;
    }
}
