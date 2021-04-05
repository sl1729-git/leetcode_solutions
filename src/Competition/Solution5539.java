package Competition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution5539 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]+100] ++;
        }
        int[] ret = new int[nums.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0){
                for (int j = 0; j < count[i]; j++) {
                    ret[index++] = count[i]*(-1000)-(i);
                }
            }
        }
        List<Integer> list = Arrays.stream(ret).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);
        for (int i = 0; i < list.size(); i++) {
            ret[ret.length-i-1] = 900 - (list.get(i)+10000000) % 1000;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3};
        Solution5539 s = new Solution5539();
        s.frequencySort(nums);
    }
}
