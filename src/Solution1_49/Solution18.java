package Solution1_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> sortedList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sortedList.sort(Integer::compareTo);
        nums = sortedList.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < nums.length-4; i++) {
            for (int j = i+1; j < nums.length-3; j++) {
                int leftIndex = j+1, rightIndex = nums.length-1;
                while (leftIndex < rightIndex){
                    int tmp = nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex];
                    if (tmp < target){
                        while (leftIndex+1 < rightIndex && nums[leftIndex]==nums[leftIndex+1])leftIndex++;
                        leftIndex++;
                    }else if (tmp > target){
                        while (rightIndex-1 > leftIndex && nums[rightIndex]==nums[rightIndex-1])rightIndex--;
                        rightIndex--;
                    }else {
                        int[] tmp2 = new int[]{nums[i],nums[j],nums[leftIndex],nums[rightIndex]};
                        ret.add(Arrays.stream(tmp2).boxed().collect(Collectors.toList()));
                        while (leftIndex+1 < rightIndex && nums[leftIndex]==nums[leftIndex+1])leftIndex++;
                        while (rightIndex-1 > leftIndex && nums[rightIndex]==nums[rightIndex-1])rightIndex--;
                        leftIndex++;
                        rightIndex--;
                    }
                }
                while (j+1 < nums.length-3 && nums[j]==nums[j+1])j++;
            }
            while (i+1 < nums.length-4 && nums[i]==nums[i+1])i++;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution18 s = new Solution18();
        int[] nums = new int[]{0,0,0,0};
        System.out.println(s.fourSum(nums,0));
    }
}
