package Solution151_300;

public class Solution191 {
    private static char[] quickCount = new char[256];
    static {
        int tmp = 1, index = 1;
        while (tmp < 256){
            for (int i = 0; i < tmp; i++) {
                quickCount[index + i] = (char)(quickCount[i] + 1);
            }
            index += tmp;
            tmp = tmp << 1;
        }
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        ret += quickCount[(n >> 0 ) & 0xff];
        ret += quickCount[(n >> 8 ) & 0xff];
        ret += quickCount[(n >> 16) & 0xff];
        ret += quickCount[(n >> 24) & 0xff];
        return ret;
    }

    public static void main(String[] args) {
        Solution191 s = new Solution191();
        System.out.println(s.hammingWeight(3));
    }
}
