package Solution50_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{{newInterval[0],newInterval[1]}};
        int leftPoint = 0, rightPoint = intervals.length-1;
        while (leftPoint < intervals.length &&
                intervals[leftPoint][1] < newInterval[0]) leftPoint++;
        while (rightPoint >= 0 &&
                intervals[rightPoint][0] > newInterval[1]) rightPoint--;
        List<int[]> ret = new ArrayList<>();
        if (leftPoint == intervals.length && rightPoint != leftPoint){
            ret.addAll(Arrays.asList(intervals));
            if (intervals[leftPoint-1][1] == newInterval[0])
                intervals[leftPoint-1][1] = newInterval[1];
            else
                ret.add(newInterval);
        }else if (rightPoint == -1 && leftPoint != rightPoint){
            if (intervals[rightPoint+1][0] == newInterval[1])
                intervals[rightPoint+1][0] = newInterval[0];
            else
                ret.add(newInterval);
            ret.addAll(Arrays.asList(intervals));
        }else if (leftPoint == rightPoint+1){
            ret.addAll(Arrays.asList(intervals));
            ret.add(leftPoint, newInterval);
        }else {
            for (int i = 0; i < leftPoint; i++) {
                ret.add(intervals[i]);
            }
            newInterval[0] = Math.min(newInterval[0], intervals[leftPoint][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[rightPoint][1]);
            ret.add(newInterval);
            for (int i = rightPoint+1; i < intervals.length; i++) {
                ret.add(intervals[i]);
            }
        }

        return ret.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
//                {1,3},{6,9}
//                {1,5}
                {3,5},{12,15}
        };
        int[] newInterval = new int[]{6,6};
        Solution57 s = new Solution57();
        System.out.println(Arrays.asList(s.insert(intervals, newInterval)));
    }
}
