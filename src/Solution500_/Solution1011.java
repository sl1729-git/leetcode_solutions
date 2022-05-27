package Solution500_;

import java.util.Arrays;

public class Solution1011 {

    private int needDays(int[] weights, int ship){
        int ret = 1, carry = ship;
        for (int weight:weights) {
            if (carry >= weight) {
                carry -= weight;
            } else{
                carry = ship - weight;
                ret ++;
            }
        }
        return ret;
    }

    /**
     * 这个是从leetcode最快题解copy的
     * @param weights
     * @param D
     * @param cap
     * @return
     */
    private boolean canFinish(int[] weights, int D, int cap) {
        int day = 1, cur = cap;
        for (int weight : weights) {
            if (weight > cur) {
                day++;
                cur = cap;
            }
            cur -= weight;
        }
        return day <= D;
    }

    public int shipWithinDays(int[] weights, int D) {
        int max = 0, sum = 0;
        for (int weight:weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int left = Math.max(max, sum/D);
        int right = Math.min(sum, sum/D + max);
        while (left <= right){
            int mid = (left + right) / 2;
            if (canFinish(weights, D, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        Solution1011 s = new Solution1011();
        System.out.println(s.shipWithinDays(weights, 5));
    }
}
