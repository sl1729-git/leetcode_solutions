package Interview;

public class Solution16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        assert shorter <= longer && shorter > 0 && k >= 0;
        if (k == 0)
            return new int[0];
        if (shorter == longer)
            return new int[]{k * shorter};
        int[] ret = new int[k+1];
        int diff = longer - shorter;
        ret[0] = shorter * k;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = ret[i-1] + diff;
        }
        return ret;
    }
}
