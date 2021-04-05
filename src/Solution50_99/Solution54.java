package Solution50_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution54 {
//    private int getLayer(int layer, int[] ret, int index, int[][] matrix){
//        int rowLen = matrix[0].length - layer * 2 - 1;
//        int colLen = matrix.length - layer * 2 - 1;
//        int rowStart = layer;
//        int colStart = layer;
//        if (rowLen <= 0){
//            for (int i = 0; i <= colLen; i++) {
//                ret[index++] = matrix[rowStart++][colStart];
//            }
//            return index;
//        }
//        if (colLen <= 0){
//            for (int i = 0; i <= rowLen; i++) {
//                ret[index++] = matrix[rowStart][colStart++];
//            }
//            return index;
//        }
//
//
//        for (int i = 0; i < rowLen; i++) {
//            ret[index++] = matrix[rowStart][colStart++];
//        }
//        for (int i = 0; i < colLen; i++) {
//            ret[index++] = matrix[rowStart++][colStart];
//        }
//        for (int i = 0; i < rowLen; i++) {
//            ret[index++] = matrix[rowStart][colStart--];
//        }
//        for (int i = 0; i < colLen; i++) {
//            ret[index++] = matrix[rowStart--][colStart];
//        }
//
//        return index;
//    }
//
//    public List<Integer> spiralOrder(int[][] matrix) {
//        int[] ret = new int[matrix.length * matrix[0].length];
//        int index = 0;
//        int layerLen = Math.min(matrix.length, matrix[0].length) / 2;
//        for (int i = 0; i < layerLen; i++) {
//            index = getLayer(i, ret, index, matrix);
//        }
//
//        if (matrix.length == matrix[0].length){
//            ret[index++] = matrix[layerLen][layerLen];
//        }
//
//        return Arrays.stream(ret).boxed().collect(Collectors.toList());
//    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1},{2},{3}
        };
        Solution54 s = new Solution54();
        System.out.println(s.spiralOrder(matrix));
    }
}
