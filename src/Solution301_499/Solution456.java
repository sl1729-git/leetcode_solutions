package Solution301_499;

import java.util.TreeMap;

public class Solution456 {

    private boolean solution_find3(int[] nums){
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }

    private boolean solution_find1(int[] nums){
        if (nums == null || nums.length < 3)
            return false;

        int max_find2 = Integer.MIN_VALUE;

        int[] stack = new int[nums.length];
        int stackTop = 0;
        stack[stackTop++] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < max_find2)
                return true;

            while (stackTop > 0 && stack[stackTop-1] < nums[i])
                max_find2 = stack[--stackTop];

            if (nums[i] > max_find2)
                stack[stackTop++] = nums[i];
        }

        return false;
    }



    public boolean find132pattern(int[] nums) {
        return solution_find1(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        Solution456 s = new Solution456();
        System.out.println(s.find132pattern(nums));
    }
}
