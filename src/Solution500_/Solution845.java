package Solution500_;

public class Solution845 {
    public int longestMountain(int[] A) {
        int ret = 0;
        if (A.length < 3)
            return ret;
        boolean upFlag = false, downFlag = false;
        int tmp = 0;
        for (int i = 1; i < A.length; i++) {
            if (!(upFlag || downFlag) && A[i] > A[i-1]){
                upFlag = true;
                tmp = 2;
            }else if (upFlag && !downFlag && A[i] > A[i-1]){
                tmp ++;
            }else if (upFlag && !downFlag && A[i] == A[i-1]){
                upFlag = false;
            }else if (upFlag && !downFlag && A[i] < A[i-1]){
                downFlag = true;
                upFlag = false;
                tmp ++;
            }else if (!upFlag && downFlag && A[i] < A[i-1]){
                tmp ++;
            }else if (!upFlag && downFlag && A[i] >= A[i-1]){
                ret = (ret < tmp) ? tmp : ret;
                i --;
                upFlag = false;
                downFlag = false;
            }
        }
        ret = (ret < tmp && downFlag) ? tmp : ret;
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1,2,3,4,5};
        Solution845 s = new Solution845();
        System.out.println(s.longestMountain(A));
    }
}
