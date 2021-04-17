package Solution151_300;

import java.util.HashMap;
import java.util.Map;

public class Solution220 {

    private long getId(long num, long distance){
        return (num >= 0) ? num/distance : ((num + 1)/distance - 1);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Integer> map = new HashMap<>();
        long distance = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], distance);
            if (map.containsKey(id))
                return true;
            if (map.containsKey(id - 1) && Math.abs((long)nums[i] - (long)map.get(id - 1)) <= t)
                return true;
            if (map.containsKey(id + 1) && Math.abs((long)nums[i] - (long)map.get(id + 1)) <= t)
                return true;

            map.put(id, nums[i]);
            if (i - k >= 0)
                map.remove(getId(nums[i - k], distance));
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,3};
        Solution220 s = new Solution220();
        System.out.println(s.containsNearbyAlmostDuplicate(nums, 2, 4));
    }
}
