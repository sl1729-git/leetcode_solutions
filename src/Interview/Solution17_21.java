package Interview;

import java.util.Stack;

public class Solution17_21 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            int currentHeight = height[i];
            while (!stack.isEmpty() && height[stack.peek()] < currentHeight){
                int preHeight = height[stack.pop()];
                ret += stack.isEmpty() ? 0 : (Math.min(currentHeight, height[stack.peek()]) - preHeight) *
                        (i - stack.peek() - 1);
            }

            stack.push(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution17_21 s = new Solution17_21();
        System.out.println(s.trap(heights));
    }
}
