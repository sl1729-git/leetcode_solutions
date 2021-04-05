package Solution50_99;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;

        int row = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    row = i;
                    break;
                }
            }
            if (row != -1)
                break;
        }

        if (row == -1)
            return;

        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] += matrix[row][i] == 0 ? 2 : -matrix[row][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[row][j]++;
                    flag = true;
                }
            }
            if (flag && i != row) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] != 1){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
}
