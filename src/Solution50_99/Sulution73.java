package Solution50_99;

import java.util.Arrays;

public class Sulution73 {
    public void setZeroes(int[][] matrix) {
        int indexRow = -1, indexCol = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    indexRow = i;
                    indexCol = j;
                    break;
                }
            }
        }
        if(indexRow == -1)
            return;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][indexCol] = matrix[i][indexCol] == 0 ? 0 : 1;
        }
        for (int i = 0; i < matrix[indexRow].length; i++) {
            matrix[indexRow][i] = matrix[indexRow][i] == 0 ? 0 : 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[indexRow][j] = 0;
                    matrix[i][indexCol] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i == indexRow)
                continue;
            if (matrix[i][indexCol] == 0)
                Arrays.fill(matrix[i],0);
        }

        for (int i = 0; i < matrix[indexRow].length; i++) {
            if (matrix[indexRow][i] == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        Arrays.fill(matrix[indexRow],0);
    }
}
