package Solution500_;

import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nums.length; j++) {
                while (!stack.empty() && nums[stack.peek()] < nums[j]){
                    ret[stack.pop()] = nums[j];
                }
                stack.push(j);
            }
        }
        return ret;
    }
}
