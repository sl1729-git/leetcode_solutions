package Solution50_99;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        assert n > 0;
        int[][] ret = new int[n][n];
        int left = 0, right = n - 1, top = 0, buttom = n - 1;
        int index = 1;
        while (left <= right && top <= buttom){
            for (int i = left; i <= right; i++) {
                ret[top][i] = index ++;
            }
            for (int i = top + 1; i <= buttom; i++) {
                ret[i][right] = index ++;
            }
            if (left < right && top < buttom){
                for (int i = right - 1; i >= left; i--) {
                    ret[buttom][i] = index ++;
                }
                for (int i = buttom - 1; i > top; i--) {
                    ret[i][left] = index ++;
                }
            }
            left ++;
            top ++;
            right --;
            buttom --;
        }

        return ret;
    }
}
