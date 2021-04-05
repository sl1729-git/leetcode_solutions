public class Solution338 {
    public int[] countBits(int num) {
        assert num >= 0;
        int[] ret = new int[num + 1];
        if (num < 1)
            return ret;
        int highestBit = 1, index = 1;
        while (index < ret.length){
            if ((highestBit & index) != 0){
                for (int i = 0; i < highestBit && index < ret.length; i++) {
                    ret[index++] = 1 + ret[i];
                }
                highestBit = highestBit << 1;
            }
        }

        return ret;
    }
}
