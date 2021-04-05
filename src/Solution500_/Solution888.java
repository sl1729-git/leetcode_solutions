package Solution500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = (sumB - sumA) / 2;
        Set<Integer> setA = Arrays.stream(A).boxed().collect(Collectors.toSet());
        for (int b:B) {
            if (setA.contains(b - diff))
                return new int[]{b - diff, b};
        }

        return new int[0];
    }
}
