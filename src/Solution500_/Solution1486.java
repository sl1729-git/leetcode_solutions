package Solution500_;

public class Solution1486 {
    public int xorOperation(int n, int start) {
        assert n >= 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret ^= (start + i * 2);
        }
        return ret;
    }
}
