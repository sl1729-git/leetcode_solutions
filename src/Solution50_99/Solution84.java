package Solution50_99;

import java.util.Arrays;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        assert  heights != null;
        if (heights.length == 0)
            return 0;

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int[] stack = new int[heights.length];
        int stackTop = 0;

        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (stackTop > 0 && heights[stack[stackTop - 1]] > heights[i]){
                right[stack[--stackTop]] = i;
            }
            left[i] = stackTop > 0 ? stack[stackTop - 1] : -1;
            stack[stackTop++] = i;
        }

        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            ret = Math.max(ret, (right[i] - left[i] - 1) * heights[i]);
        }

        return ret;
    }
}
