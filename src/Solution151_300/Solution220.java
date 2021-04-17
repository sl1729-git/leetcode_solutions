package Solution151_300;

import java.util.HashMap;
import java.util.Map;

public class Solution220 {

    private long getId(long num, long distance){
        //如此判断负数的原因是，比如-1，0，1，如果用distance = 1去划分，会分到一组
        //所以人为的，把负数放到后面一组分开，变为-2，-1一组，0，1一组
        //由于有对前后的检查，所以并不要紧
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
