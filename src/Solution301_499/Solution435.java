package Solution301_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        intervalList.addAll(Arrays.asList(intervals));
        intervalList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] != o2[0]) ? o1[0] - o2[0] : (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });
        int index = 1;
        int ret = 0;
        int[] tmp1, tmp2;
        while (index < intervalList.size()){
            tmp1 = intervalList.get(index - 1);
            tmp2 = intervalList.get(index);
            if (tmp1[1] > tmp2[0]){
                if (tmp1[1] > tmp2[1])
                    intervalList.remove(index - 1);
                else
                    intervalList.remove(index);
                ret++;
            }else
                index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,100},{11,22},{1,11},{2,12}
        };
        Solution435 s = new Solution435();
        System.out.println(s.eraseOverlapIntervals(intervals));
    }
}
