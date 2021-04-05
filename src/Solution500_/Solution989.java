package Solution500_;

import java.util.ArrayList;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        int tmp;
        for (int i = A.length - 1; i >= 0; i--) {
            tmp = (K % 10) + A[i];
            K = K / 10 + tmp /10;
            ret.add(0,tmp%10);
        }
        while (K != 0){
            ret.add(0,K%10);
            K /= 10;
        }

        return ret;
    }
}
