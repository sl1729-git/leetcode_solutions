package Solution500_;

import java.util.Arrays;

public class Solution514 {

    private static final int CHARSETSIZE = 26;

    private static int index2Distance(int index, int maxDistance){
        assert Math.abs(index) < 2 * maxDistance;
        int ret = 0, tmp = Math.abs(index);
        boolean flag = index < 0;
        ret = tmp > maxDistance ? maxDistance - tmp : tmp;
        ret *= flag ? -1 : 1;
        return ret;
    }

    private static int[][] buildMap(String ring){
        int[][] ret =new int[CHARSETSIZE][];
        int[] index = new int[CHARSETSIZE];
        int maxDistance = ring.length()/2;
        for (int i = 0; i < ring.length(); i++) {
            index[ring.charAt(i)-'a']++;
        }
        for (int i = 0; i < CHARSETSIZE; i++) {
            ret[i] = new int[index[i]];
        }
        Arrays.fill(index, 0);
        for (int i = 0; i < ring.length(); i++) {
            int tmp = ring.charAt(i)-'a';
            ret[tmp][index[tmp]++] = i;
        }

        return ret;
    }

    public int findRotateSteps(String ring, String key) {
        int[][] map = buildMap(ring);
        int[] dp = new int[ring.length()], dptmp = new int[ring.length()];
        key = new StringBuffer(key).reverse().toString();
        int maxDistance = ring.length()/2;
        for (int i = 0; i < key.length(); i++) {
            int tmp = key.charAt(i)-'a';
            for (int j = 0; j < ring.length(); j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < map[tmp].length; k++) {
                    int trueDis = index2Distance(map[tmp][k]-j, maxDistance);
                    int dis = Math.abs(trueDis)
                            + dp[(j+map[tmp][k]+1+ring.length())%ring.length()];
                    dis -= trueDis == 1 ? 1 : 0;
                    min = min < dis ? min : dis;
                }
                dptmp[j] = min;
            }
            for (int j = 0; j < dp.length; j++) {
                dp[j] = dptmp[j];
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ret = ret < dp[i] ? ret : dp[i];
        }
        return dp[0] + key.length();
    }

    public static void main(String[] args) {
//        int a = -4, b = 3;
//        System.out.println(a%b);
        Solution514 s = new Solution514();
        String ring = "godding", key = "godding";
        System.out.println(s.findRotateSteps(ring, key));
    }
}
