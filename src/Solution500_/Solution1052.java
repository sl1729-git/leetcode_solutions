package Solution500_;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers.length == 0)
            return 0;
        int ret = 0;
        int maxCoverGrumpy = 0;
        for (int i = 0; i < X; i++) {
            maxCoverGrumpy += grumpy[i] == 1 ? customers[i] : 0;
        }

        int currentCoverGrumpy = maxCoverGrumpy;
        for (int i = 0; i < customers.length ; i++) {
            ret += grumpy[i] == 0 ? customers[i] : 0;
        }

        for (int i = 1; i <= customers.length - X; i++) {
            currentCoverGrumpy -= grumpy[i - 1] == 1 ? customers[i - 1] : 0;
            currentCoverGrumpy += grumpy[i + X - 1] == 1 ? customers[i + X - 1] : 0;
            maxCoverGrumpy = Math.max(maxCoverGrumpy, currentCoverGrumpy);
        }

        return ret + maxCoverGrumpy;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy    = new int[]{0,1,0,1,0,1,0,1};
        Solution1052 s = new Solution1052();
        System.out.println(s.maxSatisfied(customers, grumpy, 3));
    }
}
