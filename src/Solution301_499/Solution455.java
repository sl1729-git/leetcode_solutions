package Solution301_499;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        List<Integer> tmp = Arrays.stream(g).boxed().collect(Collectors.toList());
        tmp.sort(Integer::compareTo);
        g = tmp.stream().mapToInt(Integer::valueOf).toArray();
        tmp = Arrays.stream(s).boxed().collect(Collectors.toList());
        tmp.sort(Integer::compareTo);
        s = tmp.stream().mapToInt(Integer::valueOf).toArray();
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index >= g.length)
                break;
            if (s[i] >= g[index])
                index ++;
        }
        return index;
    }
}
