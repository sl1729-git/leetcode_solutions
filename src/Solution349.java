import java.util.*;
import java.util.stream.Collectors;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] shortOne = nums1.length < nums2.length ? nums1 : nums2;
        int[] longOne  = shortOne == nums1 ? nums2 : nums1;
        Set<Integer> tmp = Arrays.stream(longOne).boxed().collect(Collectors.toSet());
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < shortOne.length; i++) {
            if (tmp.contains(shortOne[i])){
                tmp.remove(shortOne[i]);
                ret.add(shortOne[i]);
            }
        }
        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
}
