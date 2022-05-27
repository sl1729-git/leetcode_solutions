package Solution301_499;

import java.util.*;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        for (int[] p:points) {
            Map<Integer, Integer> distanceCount= new HashMap<>();
            for (int[] q:points) {
                int diffX = p[0] - q[0], diffY = p[1] - q[1];
                int distance = diffX * diffX + diffY * diffY;
                distanceCount.put(distance, distanceCount.getOrDefault(distance, 0) + 1);
            }

            for (Integer distance:distanceCount.keySet()) {
                int count = distanceCount.get(distance);
                ret += count * (count - 1);
            }
        }
        return ret;
    }
}

