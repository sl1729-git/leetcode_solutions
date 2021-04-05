package Solution1_49;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int[] tmp = new int[matrix.length-1];
        int round = 0, tmp2 = 0, len = tmp.length;
        for (int i = 0; i < matrix.length/2; i++) {
            len = matrix.length - round*2 -1;
            for (int j = 0; j < len; j++) {
                tmp[j] = matrix[round][j+1+round];
                matrix[round][j+1+round] = matrix[matrix.length-2-j-round][round];
            }
            for (int j = 0; j < len; j++) {
                tmp2 = matrix[j+1+round][matrix.length-round-1];
                matrix[j+1+round][matrix.length-round-1] = tmp[j];
                tmp[j] = tmp2;
            }
            for (int j = 0; j < len; j++) {
                tmp2 = matrix[matrix.length-round-1][matrix.length-j-2-round];
                matrix[matrix.length-round-1][matrix.length-j-2-round] = tmp[j];
                tmp[j] = tmp2;
            }
            for (int j = 0; j < len; j++) {
                matrix[matrix.length-2-j-round][round] = tmp[j];
            }
            round ++;
        }
    }

    public static void main(String[] args) {
        Solution48 s = new Solution48();
        int[][] matrix = new int[][]{
                {2,29,20,26,16,28},
                {12,27,9,25,13,21},
                {32,33,32,2,28,14},
                {13,14,32,27,22,26},
                {33,1,20,7,21,7},
                {4,24,1,6,32,34}
        };
        s.rotate(matrix);
        s.rotate(matrix);
    }
}
