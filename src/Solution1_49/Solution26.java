package Solution1_49;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
