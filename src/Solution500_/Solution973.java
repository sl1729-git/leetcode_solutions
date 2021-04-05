package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution973 {


    private int[][] solution1(int[][] points, int K){
        if (points == null || K == points.length)
            return points;
        List<int[]> list = new ArrayList<>(Arrays.asList(points));
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0] + o1[1]*o1[1] - o2[0]*o2[0]- o2[1]*o2[1];
            }
        });
        int[][] ret = new int[K][];
        for (int i = 0; i < K; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int[][] kClosest(int[][] points, int K) {
        return solution1(points, K);
    }
}
