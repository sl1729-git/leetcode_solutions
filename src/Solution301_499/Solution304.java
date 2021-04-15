package Solution301_499;

public class Solution304 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };

        NumMatrix s = new NumMatrix(matrix);
        System.out.println(s.sumRegion(2,1,4,3));
    }

}

class NumMatrix {
    private int[][] matrixSum;

    public NumMatrix(int[][] matrix) {
        int rowNum = matrix.length + 1;
        int colNum = matrix.length == 0 ? 1 : matrix[0].length + 1;
        matrixSum = new int[rowNum][colNum];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                matrixSum[i + 1][j + 1] = sum;
            }
        }

        for (int i = 1; i < matrixSum.length; i++) {
            for (int j = 0; j < matrixSum[i].length; j++) {
                matrixSum[i][j] += matrixSum[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row2 + 1][col2 + 1] - matrixSum[row2 + 1][col1] -
                matrixSum[row1][col2 + 1] + matrixSum[row1][col1];
    }
}