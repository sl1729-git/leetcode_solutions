import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        assert A != null && B != null && C != null && D != null;
        assert A.length == B.length && B.length == C.length && C.length == D.length;
        int length = A.length;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map1.put(i*length+j, A[i]+B[j]);
                if (map2.containsKey(C[i]+D[j])) {
                    map2.put(C[i] + D[j], map2.get(C[i] + D[j]) + 1);
                } else {
                    map2.put(C[i] + D[j], 1);
                }
            }
        }

        int ret = 0;
        for (Integer abIndex : map1.keySet()) {
            if (map2.containsKey(-map1.get(abIndex)))
                ret += map2.get(-map1.get(abIndex));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1,-1};
        int[] B = new int[]{-1,1};
        int[] C = new int[]{1,-1};
        int[] D = new int[]{1,-1};

        Solution454 s = new Solution454();
        System.out.println(s.fourSumCount(A, B, C, D));
    }
}
