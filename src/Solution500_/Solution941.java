package Solution500_;

public class Solution941 {
    public boolean validMountainArray(int[] A) {
        boolean tmp1, tmp2;
        boolean hasUp = false, hasDown = false;
        for (int i = 1; i < A.length; i++) {
            tmp1 = A[i] > A[i-1];
            tmp2 = A[i] < A[i-1];
            if (tmp1 && hasDown)
                return false;
            if (!(tmp1 || tmp2))
                return false;
            hasUp = tmp1 | hasUp;
            hasDown = tmp2 | hasDown;
        }
        return hasDown && hasUp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,3,2,1};
        Solution941 s = new Solution941();
        System.out.println(s.validMountainArray(A));
    }
}
