package Offer;

public class Solution16 {
    /**
     * 偷懒做法
     * @param n 一个长度为32的二进制数
     * @return 返回二进制表示下1的个数
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
