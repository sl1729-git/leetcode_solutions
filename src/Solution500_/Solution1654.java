package Solution500_;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[] fp = new int[2000 + a * 2];
        boolean[] arrive = new boolean[fp.length];
        Arrays.fill(fp, Integer.MAX_VALUE);
        for (int i = 0; i < forbidden.length; i++) {
            fp[forbidden[i]] = -1;
        }
        Queue<Integer> position = new ArrayDeque<>();
        position.add(0);
        int curentPosition = 0;
        fp[0] = 0;
        while (!position.isEmpty()){
            curentPosition = position.poll();
            if (curentPosition + a < fp.length && fp[curentPosition + a] != -1) {
                fp[curentPosition + a] = Math.min(fp[curentPosition] + 1, fp[curentPosition + a]);
                if (!arrive[curentPosition + a]) {
                    arrive[curentPosition + a] = true;
                    position.add(curentPosition + a);
                }
                if (curentPosition + a == x)
                    return fp[curentPosition + a];
            }
            if (curentPosition - b >= 0 && fp[curentPosition - b] != -1) {
                fp[curentPosition - b] = Math.min(fp[curentPosition] + 1, fp[curentPosition - b]);
                if (!arrive[curentPosition - b]) {
                    arrive[curentPosition - b] = true;
                    position.add(curentPosition - b);
                }
                if (curentPosition - b == x)
                    return fp[curentPosition - b];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = new int[]{8,3,16,6,12,20};
        Solution1654 s = new Solution1654();
        System.out.println(s.minimumJumps(forbidden, 15,13,11));
    }
}
