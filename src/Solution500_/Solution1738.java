package Solution500_;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1738 {
    private int[] matrix2array(int[][] matrix){
        int[] ret = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ret[index++] = matrix[i][j];
            }
        }

        return ret;
    }

    private int findKMax(int[] array, int k, int left, int right){
//        assert array.length >= k;
        int base = array[right];
        int i = left, j = right;
        while (i < j){
            while (i < j && base <= array[i])i++;
            if (i < j) {
                array[j--] = array[i];
            }
            while (i < j && base >= array[j])j--;
            if (i < j) {
                array[i++] = array[j];
            }
        }
        array[i] = base;
        if (i == k - 1)
            return base;
        else if (i < k - 1)
            return findKMax(array, k, i + 1, right);
        else
            return findKMax(array, k, left, i - 1);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        assert matrix != null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] ^= matrix[i][j-1];
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] ^= matrix[i-1][j];
            }
        }

        int[] arr = matrix2array(matrix);
        return findKMax(arr, k, 0, arr.length - 1);
    }

    public int solution(int[][] matrix, int k){
        assert k > 0 && matrix != null;
        Queue<Integer> queue = new PriorityQueue<>();
        int[][] out = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++) {
                out[i][j] = out[i-1][j-1] ^ out[i-1][j] ^ out[i][j-1] ^ matrix[i-1][j-1];
                if (queue.size() < k)
                    queue.add(out[i][j]);
                else if (out[i][j] > queue.peek()){
                    queue.poll();
                    queue.add(out[i][j]);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{6,1,3,0,9},{7,2,0,0,8},{5,4,8,4,5},{6,4,1,1,9},{7,2,3,4,7}};
        int[] arr = {4,2,3,1};
        Solution1738 s = new Solution1738();
        System.out.println(s.kthLargestValue(matrix, 25));
        System.out.println(s.findKMax(arr, 1, 0, arr.length - 1));
    }
}
