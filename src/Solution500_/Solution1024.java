package Solution500_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1024 {

    public int videoStitching(int[][] clips, int T) {
        int ret = 0, currentLeft = 0, tmp = -1;
        List<int[]> list = Arrays.asList(clips);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        while (currentLeft < T){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] > currentLeft){
                    break;
                }else {
                    tmp = list.get(i)[1] > tmp ? list.get(i)[1] : tmp;
                }
            }
            if (currentLeft == tmp)
                return -1;
            currentLeft = tmp;
            ret ++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{
                {0,2},{2,4}
        };
        Solution1024 s = new Solution1024();
        System.out.println(s.videoStitching(clips ,10));
    }
}
