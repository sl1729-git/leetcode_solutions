package Solution1_49;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int  tmp = 0, min_distance = Integer.MAX_VALUE;
        int ret = 0;
        List<Integer> sorted_list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sorted_list.sort(Integer::compareTo);
        nums = sorted_list.stream().mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < nums.length; i++) {
            int left_index = i+1, right_index = nums.length-1;
            while (left_index < right_index){
                tmp = nums[i] + nums[left_index] + nums[right_index];
                if (Math.abs(target-tmp)<min_distance){
                    min_distance = Math.abs(target-tmp);
                    ret = tmp;
                }
                if (tmp < target){
                    while(left_index+1 < right_index && nums[left_index] == nums[left_index+1])left_index++;
                    left_index++;
                }else if (tmp > target){
                    while (right_index-1 > left_index && nums[right_index] == nums[right_index-1])right_index--;
                    right_index--;
                }else {
                    return tmp;
                }
            }
            while (i+1 < nums.length && nums[i] == nums[i+1])i++;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(s.threeSumClosest(nums,1));
    }
}
