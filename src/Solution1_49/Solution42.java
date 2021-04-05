package Solution1_49;

public class Solution42 {
    //暴力法，会超过时间
//    private long loop(int[] height){
//        long ret = 0;
//        long min = Integer.MAX_VALUE;
//        for (int i = 0; i < height.length; i++) {
//            min = (min > height[i] && height[i] > 0) ? height[i] : min;
//        }
//        int interval = 0, indexleft = -1, indexright = -1;
//        for (int i = 0; i < height.length; i++) {
//            indexleft = (height[i] >= min && indexleft == -1) ? i : indexleft;
//            indexright = (height[height.length-i-1] >= min && indexright == -1) ? height.length-i : indexright;
//            if (indexleft != -1 && indexright != -1)
//                break;
//        }
//        for (int i = indexleft; i < indexright; i++) {
//            ret += (height[i] < min) ? min-height[i] : 0;
//            height[i] = (int)((height[i] <= min) ? 0 : height[i]-min);
//        }
//        min = (min == Integer.MAX_VALUE) ? 0 : min;
//        return ret | (min << 32);
//    }
//
//    public int trap(int[] height) {
//        int ret = 0;
//        long tmp = -1;
//        while (tmp != 0){
//            tmp = loop(height);
//            ret += (int)(tmp & 0xffffffff);
//        }
//        return ret;
//    }


    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int ret = 0, indexleft = -1, indexright = -1, indexmax = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            indexmax = (height[indexmax] < height[i]) ? i : indexmax;
            indexleft = (indexleft == -1 && height[i] > 0) ? i : indexleft;
            indexright = (indexright == -1 && height[height.length-i-1] > 0) ? height.length-i : indexright;
        }
        if (indexleft == -1)
            return 0;
        int tmp = height[indexleft];
        for (int i = indexleft+1; i < indexmax+1; i++) {
            ret += (height[i] < tmp) ? tmp-height[i] : 0;
            tmp = (height[i] > tmp) ? height[i] : tmp;
        }
        tmp = height[indexright-1];
        for (int i = indexright-1; i >= indexmax; i--) {
            ret += (height[i] < tmp) ? tmp-height[i] : 0;
            tmp = (height[i] > tmp) ? height[i] : tmp;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        Solution42 s = new Solution42();
        System.out.println(s.trap(height));
    }
}
