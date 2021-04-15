package Solution301_499;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int index = 0, nextIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] - 1;
            if (index == -2)
                continue;
            nextIndex = nums[index] - 1;
            nums[index] = -1;
            while (nextIndex != -2 && nums[nextIndex] != -1){
                index = nums[nextIndex] - 1;
                nums[nextIndex] = -1;
                nextIndex = index;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1)
                ret.add(i + 1);
        }
        return ret;
    }
}
