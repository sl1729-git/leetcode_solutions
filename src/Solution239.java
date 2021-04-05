import java.util.ArrayList;
import java.util.List;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
            }else {
                while (!stack.isEmpty()){
                    if (nums[i] >= nums[stack.get(stack.size()-1)])
                        stack.remove(stack.size()-1);
                    else
                        break;
                }
                stack.add(i);
            }
        }
        int[] ret = new int[nums.length-k+1];
        ret[0] = nums[stack.get(0)];
        for (int i = k; i < nums.length; i++) {
            if (stack.get(0) <= i - k)
                stack.remove(0);
            while (!stack.isEmpty()){
                if (nums[i] > nums[stack.get(stack.size()-1)])
                    stack.remove(stack.size()-1);
                else
                    break;
            }
            stack.add(i);
            ret[i-k+1] = nums[stack.get(0)];
        }
        return ret;
    }
}
