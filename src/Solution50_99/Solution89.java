package Solution50_99;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        assert n >= 0 && n <= 32;
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        if (n == 0)
            return ret;
        ret.add(1);
        for (int i = 1; i < n; i++) {
            int currentSize = ret.size();
            for (int j = 0; j < currentSize; j++) {
                ret.add(ret.get(currentSize-j-1) | (1 << i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution89 s = new Solution89();
        System.out.println(s.grayCode(3));
    }
}
