package Solution301_499;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret += (tmp & (1 << i)) != 0 ? 1 : 0;
        }

        return ret;
    }
}
