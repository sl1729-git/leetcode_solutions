import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution452 {

    private int shot(int[][] points, int index){
        if (index >= points.length)
            return -1;
        else if (index == points.length - 1)
            return 0;
        int ret = 1, left = points[index][0], right = points[index][1];
        while (true){
            if (index + ret == points.length || points[index + ret][0] > right)
                return ret;
            right = points[index + ret][1] > right ? right : points[index + ret][1];
            ret ++;
        }
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        List<int[]> list = Arrays.asList(points);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        points = list.toArray(new int[0][0]);
        int ret = 0, index = 0, tmp = 0;
        while ((tmp=shot(points,index)) > 0){
            ret ++;
            index += tmp;
        }
        return ret + ((tmp == 0) ? 1 : 0);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        Solution452 s = new Solution452();
        System.out.println(s.findMinArrowShots(points));
    }
}
