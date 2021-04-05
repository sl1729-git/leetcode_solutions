package Solution500_;

public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int count0 = 0;
        int ret = 0;
        while (right < A.length && left < A.length){
            while (right < A.length && count0 < K){
                count0 += A[right] == 0 ? 1 : 0;
                right ++;
            }
            while (right < A.length && A[right] == 1)right++;
            ret = Math.max(ret, right - left);
            count0 -= A[left++] == 0 ? 1 : 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,0,1,1,1,0,0};
        Solution1004 s = new Solution1004();
        System.out.println(s.longestOnes(A, 0));
    }
}
