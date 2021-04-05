package Competition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution5540 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] tmp = new int[points.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = points[i][0];
        }
        List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);
        int ret = -1, tmp1, tmp2;
        for (int i = 1; i < list.size(); i++) {
            tmp1 = list.get(i-1);
            tmp2 = list.get(i);
            ret = (tmp2-tmp1 > ret) ? tmp2-tmp1 : ret;
        }
        return ret;
    }
}
