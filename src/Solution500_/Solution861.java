package Solution500_;

public class Solution861 {
    private void flipRow(int[][] A, int row){
        for (int i = 0; i < A[row].length; i++) {
            A[row][i] = A[row][i] == 1 ? 0 : 1;
        }
    }

    private void flipCol(int[][] A, int col){
        for (int i = 0; i < A.length; i++) {
            A[i][col] = A[i][col] == 1 ? 0 : 1;
        }
    }

    private int getScore(int[][] A){
        int ret = 0;
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = 0;
            for (int j = A[i].length-1; j >= 0; j--) {
                tmp += A[i][j] << A[i].length-j-1;
            }
            ret += tmp;
        }
        return ret;
    }

    public int matrixScore(int[][] A) {
        int ret = 0;
        if (A == null || A.length == 0 || A[0].length == 0)
            return ret;
        ret = getScore(A);
        int preScore = -1, count = 0;
        int colLength = A.length, rowLength = A[0].length;
        while (ret != preScore){
            preScore = ret;
            for (int i = 0; i < A.length; i++) {
                if (A[i][0] != 1)
                    flipRow(A, i);
            }
            for (int i = 0; i < A[0].length; i++) {
                count = 0;
                for (int j = 0; j < colLength; j++) {
                    count += A[j][i];
                }
                if (count < colLength-count)
                    flipCol(A,i);
            }
            ret = getScore(A);
        }
        return ret;
    }
}
