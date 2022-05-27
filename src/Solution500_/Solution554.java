package Solution500_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> skipCount = new HashMap<>();
        int sum = 0;
        for (List<Integer> row:wall) {
            sum = 0;
            for (Integer len:row) {
                sum += len;
                skipCount.put(sum, skipCount.getOrDefault(sum, 0) + 1);
            }
        }
        skipCount.remove(sum);

        int ret = wall.size();
        int wallHeight = wall.size();
        for (Integer skip:skipCount.keySet()) {
            ret = Math.min(ret, wallHeight - skipCount.get(skip));
        }

        return ret;
    }
}
