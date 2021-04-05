package Solution500_;

public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        for (int i = 0; i < colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (i + j < colLen && matrix[j][i + j] != matrix[0][i])
                    return false;
            }
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (i + j < rowLen && matrix[i + j][j] != matrix[i][0])
                    return false;
            }
        }

        return true;
    }
}
