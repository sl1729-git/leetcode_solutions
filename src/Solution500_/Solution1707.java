package Solution500_;

import java.util.Arrays;

public class Solution1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        if (queries == null || nums == null)
            return null;
        int max = Integer.MIN_VALUE;
        for (int num:nums) {
            max = max < num ? num : max;
        }
        int maxBitIndex = 31;
        while ((max & (1 << maxBitIndex)) == 0)
            maxBitIndex --;

        Trie root = new Trie(maxBitIndex);
        int[] ret = new int[queries.length];
        for (int num:nums) {
            root.insert(num);
        }

        for (int i = 0; i < queries.length; i++) {
            ret[i] = root.search(queries[i][0],queries[i][1]);
            if (ret[i] != -1){
                ret[i] |= (queries[i][0] & (-(1 << maxBitIndex)));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,4,6,6,3};
        int[][] queries = new int[][]{{12,4},{8,1},{6,3}};
        Solution1707 s = new Solution1707();
        System.out.println(Arrays.toString(s.maximizeXor(nums, queries)));
    }
}

class Trie{
    private int min = Integer.MAX_VALUE;
    private int currentBitIndex;
    private Trie[] child = new Trie[2];
    private static int MAX_BIT = 30;

    public Trie(){

    }

    public Trie(int currentBitIndex){
        this.currentBitIndex = currentBitIndex;
    }

    private void insert(int value, int bitIndex){
        Trie node = this;
        node.min = Math.min(value, min);
        if (bitIndex < 0)
            return;
        int bit = 0;
        bit = (value >> bitIndex) & 1;
        if (node.child[bit] == null)
            node.child[bit] = new Trie(bitIndex - 1);
        node.child[bit].insert(value, bitIndex - 1);
    }

    public void insert(int value){
        insert(value, currentBitIndex);
    }

    public int search(int value, int max){
        Trie node = this;
        if (node.min > max)
            return -1;

        int ret = 0;

        for (int i = currentBitIndex; i >= 0; i--) {
            int bit = (value >> i) & 1;
            if (node.child[bit ^ 1] != null && node.child[bit ^ 1].min <= max){
                ret |= (1 << i);
                bit ^= 1;
            }
            node = node.child[bit];
        }

        return ret;
    }

}
