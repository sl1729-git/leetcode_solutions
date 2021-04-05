package Solution50_99;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        assert nums1 != null && nums2 != null;
        assert nums1.length == m + n && nums2.length == n;
        int mergeIndex = nums1.length - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;

        while (nums1Index >= 0 && nums2Index >= 0){
            if (nums1[nums1Index] >= nums2[nums2Index])
                nums1[mergeIndex--] = nums1[nums1Index--];
            else
                nums1[mergeIndex--] = nums2[nums2Index--];
        }

        for (int i = 0; i <= nums2Index; i++) {
            nums1[i] = nums2[i];
        }
    }
}
