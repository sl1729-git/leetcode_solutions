package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        int left = 0, right = 0;
        Map<Integer, Integer> intCount = new HashMap<>();
        int len = A.length - K + 1;
        int ret = 0;
        int exLen = 0;
        while (left < len){
            while (right < A.length && intCount.size() < K) {
                intCount.put(A[right], intCount.getOrDefault(A[right], 0) + 1);
                right++;
            }
            while (right + exLen < A.length && intCount.containsKey(A[right + exLen]))
                exLen ++;
            if (intCount.size() == K)
                ret += exLen + 1;
            if (intCount.get(A[left]) == 1)
                intCount.remove(A[left]);
            else
                intCount.put(A[left], intCount.get(A[left]) - 1);
            left++;
            exLen = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,1,2,3};
        Solution992 s = new Solution992();
        System.out.println(s.subarraysWithKDistinct(A, 2));
    }
}
