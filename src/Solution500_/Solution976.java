package Solution500_;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution976 {
    public int largestPerimeter(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);
        int i = list.size() - 1;
        int j = i - 1, k = i - 2;
        int tmp;
        while (k >= 0){
            if (list.get(i) >= list.get(j) + list.get(k)){
                tmp = j;
                j = k;
                i = tmp;
                k = k - 1;
            }else {
                return list.get(i) + list.get(j) + list.get(k);
            }
        }
        return 0;
    }
}
