package Solution100_150;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int ret = 0;
        int candyForChild = 1;
        int[] candyForAChild = new int[ratings.length];
        Arrays.fill(candyForAChild,1);
        for (int i = 1; i < ratings.length; i++) {
            candyForChild = ratings[i] > ratings[i-1] ? candyForChild + 1 : 1;
            candyForAChild[i] = candyForChild;
        }
        candyForChild = 1;
        for (int i = ratings.length-2; i >= 0; i--) {
            candyForChild = ratings[i] > ratings[i+1] ? candyForChild + 1 : 1;
            ret += candyForAChild[i] < candyForChild ? candyForChild : candyForAChild[i];
        }
        return ret + candyForAChild[candyForAChild.length-1];
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,0,2};
        Solution135 s = new Solution135();
        System.out.println(s.candy(ratings));
    }
}
