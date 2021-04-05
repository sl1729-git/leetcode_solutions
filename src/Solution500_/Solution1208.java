package Solution500_;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];
        int currentCost = 0;
        int left = 0, right = 0;
        int ret = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        while (right < diff.length){
            while (right < diff.length && currentCost <= maxCost){
                currentCost += diff[right++];
            }
            if (currentCost > maxCost)
                currentCost -= diff[--right];
            ret = (right - left) > ret ? right - left : ret;
            currentCost -= left == right ? 0 : diff[left];
            right = Math.max(right, ++left);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1208 s = new Solution1208();
        String S = "abcd", T = "cdef";
        System.out.println(s.equalSubstring(S, T, 1));
    }
}
