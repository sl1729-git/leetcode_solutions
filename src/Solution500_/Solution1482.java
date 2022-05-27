package Solution500_;

public class Solution1482 {
    private int canMake(int[] bloomDay, int day, int k){
        int ret = 0;
        int currentGet = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            currentGet = bloomDay[i] <= day ? currentGet + 1 : 0;
            if (currentGet >= k){
                ret ++;
                currentGet = 0;
            }
        }

        return ret;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || m * k > bloomDay.length)
            return -1;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        int currentDay = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            currentDay = bloomDay[i];
            left = left < currentDay ? left : currentDay;
            right = right > currentDay ? right : currentDay;
        }

        while (left < right){
            int mid = (left + right) / 2;
            int make = canMake(bloomDay, mid, k);
            if (make < m){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution1482 s = new Solution1482();
        int[] bloomDay = new int[]{10000000,10000000};
        System.out.println(s.minDays(bloomDay, 1, 1));
    }
}
