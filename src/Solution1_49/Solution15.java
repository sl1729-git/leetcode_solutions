package Solution1_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0, tmp = 0;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> sorted_list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sorted_list.sort(Integer::compareTo);
        nums = sorted_list.stream().mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < nums.length; i++) {
            int left_index = i+1, right_index = nums.length-1;
            while (left_index < right_index){
                tmp = nums[i] + nums[left_index] + nums[right_index];
                if (tmp < target){
                    while(left_index+1 < right_index && nums[left_index] == nums[left_index+1])left_index++;
                    left_index++;
                }else if (tmp > target){
                    while (right_index-1 > left_index && nums[right_index] == nums[right_index-1])right_index--;
                    right_index--;
                }else {
                    int[] tmp2 = new int[]{nums[i],nums[left_index],nums[right_index]};
                    ret.add(Arrays.stream(tmp2).boxed().collect(Collectors.toList()));
                    while(left_index+1 < right_index && nums[left_index] == nums[left_index+1])left_index++;
                    while (right_index-1 > left_index && nums[right_index] == nums[right_index-1])right_index--;
                    left_index++;
                    right_index--;
                }
            }
            while (i+1 < nums.length && nums[i] == nums[i+1])i++;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution15 s15 = new Solution15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(s15.threeSum(nums));
    }
}
