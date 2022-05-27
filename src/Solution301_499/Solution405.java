package Solution301_499;

public class Solution405 {
    private static char[] HEX = new char[16];
    static {
        for (int i = 0; i < 10; i++) {
            HEX[i] = (char) ('0' + i);
        }

        for (int i = 0; i < 6; i++) {
            HEX[i + 10] = (char) ('a' + i);
        }
    }

    public String toHex(int num) {
        StringBuilder ret = new StringBuilder();
        int count = 0;
        do {
            int index = num & 0xf;
            num = num >> 4;
            count ++;
            ret.append(HEX[index]);
        }while (num != 0 && count < 8);

        ret.reverse();
        return ret.toString();
    }
}
