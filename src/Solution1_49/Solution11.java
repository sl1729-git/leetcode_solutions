package Solution1_49;

public class Solution11 {

    public int maxArea(int[] height) {
        int ret = 0;
        int left_index = 0, right_index = height.length-1;
        while (left_index < right_index){
            if (ret < (right_index-left_index)*Math.min(height[left_index],height[right_index]))
                ret = (right_index-left_index)*Math.min(height[left_index],height[right_index]);
            if (height[left_index] <= height[right_index]){
                left_index++;
            }else {
                right_index--;
            }
        }

        return ret;
    }
}
