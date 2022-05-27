package Solution500_;

public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] bigger = nums1.length > nums2.length ? nums1 : nums2;
        int[] smaller = nums1 == bigger ? nums2 : nums1;
        int[] dp = new int[smaller.length];
        dp[0] = bigger[0] == smaller[0] ? 1 : 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1], bigger[0] == smaller[i] ? 1 : 0);
        }
        int current;
        for (int i = 1; i < bigger.length; i++) {
            int pre = dp[0];
            dp[0] = Math.max(dp[0], bigger[i] == smaller[0] ? 1 : 0);
            for (int j = 1; j < smaller.length; j++) {
                current = dp[j];
                dp[j] = bigger[i] == smaller[j] ? pre + 1 : Math.max(dp[j-1], current);
                pre = current;
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution1035 s = new Solution1035();
        int[] nums1 = {1,1,2,1}, nums2 = {3,3,1};
        System.out.println(s.maxUncrossedLines(nums1,nums2));
    }
}
