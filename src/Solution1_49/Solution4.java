package Solution1_49;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0){
            return nums2.length%2==0 ? (double)(nums2[nums2.length/2]+nums2[(nums2.length-1)/2])/2 : nums2[nums2.length/2];
        }
        if (nums2.length == 0){
            return nums1.length%2==0 ? (double)(nums1[nums1.length/2]+nums1[(nums1.length-1)/2])/2 : nums1[nums1.length/2];
        }
        int midIndex = (nums1.length + nums2.length - 1) / 2;
        int nums1Left = 0, nums2Left = 0, nums1Right = nums1.length-1, nums2Right = nums2.length-1;
        int left = 0, right = nums1.length + nums2.length-1;
        double ret = 0;
        while (nums1Right-nums1Left > 1 || nums2Right-nums2Left >1){
            int nums1MidIndex = (nums1Right+nums1Left)/2;
            int nums2MidIndex = (nums2Right+nums2Left)/2;
            if (nums1[nums1MidIndex] < nums2[nums2MidIndex]){
                left += nums1MidIndex-nums1Left;
                right -= nums2Right - nums2MidIndex;
                nums1Left  = nums1MidIndex;
                nums2Right = nums2MidIndex;
            }else {
                left += nums2MidIndex - nums2Left;
                right -= nums1Right-nums1MidIndex;
                nums1Right = nums1MidIndex;
                nums2Left  = nums2MidIndex;
            }
            if (midIndex-left == 0 || right-midIndex == 0)
                break;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums1[nums1Left]);
        tmp.add(nums2[nums2Left]);
        if (nums1Left != nums1Right)
            tmp.add(nums1[nums1Right]);
        if (nums2Left != nums2Right)
            tmp.add(nums2[nums2Right]);
        tmp.sort(Integer::compareTo);
        if ((nums1.length + nums2.length) % 2 == 0){
            ret = (double) (tmp.get(midIndex-left)+tmp.get(midIndex-left+1))/2;
        }else {
            ret = tmp.get(midIndex-left);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7};
        int[] nums2 = new int[]{2,3,4,5,6};
        Solution4 s = new Solution4();
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }

}
