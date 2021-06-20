package Solution301_499;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {
    /**
     * 我实在是不想剪枝去搜索，虽然更快一些
     * @param turnedOn 点亮的led灯数量
     * @return 所有点亮了turnedOn个led的合法时间
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            if (Integer.bitCount(i) != turnedOn)
                continue;
            int hour = (i >> 6) & 0xf;
            int minute = i & 0x3f;
            if (hour > 11 || minute > 59)
                continue;
            ret.add(String.format("%d:%02d",hour,minute));
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution401 s = new Solution401();
        System.out.println(s.readBinaryWatch(1));
    }
}
