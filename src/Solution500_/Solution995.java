package Solution500_;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution995 {
    public int solutionBad(int[] A, int K) {
        int ret = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            if (A[i] == 1)
                continue;
            for (int j = 0; j < K; j++) {
                A[i + j] = (A[i + j] == 1) ? 0 : 1;
            }
            ret ++;
        }
        for (int i = 0; i < K; i++) {
            if (A[A.length - K + i] == 0)
                return -1;
        }
        return ret;
    }

    public int minKBitFlips(int[] A, int K) {
        int ret = 0, currentFilp = 0;
        Queue<Boolean> queue = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            queue.add(false);
        }

        for (int i = 0; i < A.length - K + 1; i++) {
            currentFilp -= queue.poll() ? 1 : 0;
            if ((A[i] + currentFilp) % 2 == 0){
                queue.add(true);
                currentFilp ++;
                ret ++;
            }else
                queue.add(false);
        }

        for (int i = A.length - K + 1; i < A.length; i++) {
            currentFilp -= queue.poll() ? 1 : 0;
            if ((A[i] + currentFilp) % 2 == 0)
                return -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,0};
        Solution995 s = new Solution995();
        System.out.println(s.minKBitFlips(A, 2));
    }
}
