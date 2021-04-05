package Solution500_;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1)
                continue;
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length-1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                max ++;
            }
        }
        return max >= n;
    }
}
