package Solution50_99;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        assert nums != null && nums.length <= 40;
        long choice = 0;
        long up = (1 << nums.length) - 1;
        List<List<Integer>> ret = new ArrayList<>();
        for (; choice <= up; choice++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((choice & (1 << j)) != 0)
                    tmp.add(nums[j]);
            }
            ret.add(tmp);
        }
        return ret;
    }
}
