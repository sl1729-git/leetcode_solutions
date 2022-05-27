package Solution500_;

public class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (queries == null || arr == null)
            return new int[0];
        int[] ret = new int[queries.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0)
                ret[i] = arr[end];
            else
                ret[i] = arr[end] ^ arr[start - 1];
        }

        return ret;
    }
}
