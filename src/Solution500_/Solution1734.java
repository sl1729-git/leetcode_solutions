package Solution500_;

public class Solution1734 {
    public int[] decode(int[] encoded) {
        int[] ret = new int[encoded.length + 1];
        int ret0 = 0;
        for (int i = 1; i <= ret.length; i++) {
            ret0 ^= i;
        }

        for (int i = 1; i < encoded.length; i+=2) {
            ret0 ^= encoded[i];
        }

        ret[0] = ret0;

        for (int i = 0; i < encoded.length; i++) {
            ret[i + 1] = ret[i] ^ encoded[i];
        }

        return ret;
    }
}
