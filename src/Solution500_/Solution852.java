package Solution500_;

public class Solution852 {
    /**
     * 这个因为保证了一定会有结果，所以可以二分处理
     * @param arr 输入的数组
     * @return 如果arr为null或长度小于3或不存在峰，返回-1
     *          如果arr存在峰，则返回一个峰，不保证次序
     */
    public int peakIndexInMountainArray(int[] arr) {
        int ret = -1;
        if (arr == null || arr.length < 3)
            return ret;
        int left = 0, right = arr.length - 1;
        while (left < right){
            int mid = (right + left) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                ret = mid + 1;
                left = ret;
            }
            else
                right = mid;
        }

        return ret == 0 || ret == arr.length - 1 ? -1 : ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0};
        Solution852 s = new Solution852();
        System.out.println(s.peakIndexInMountainArray(arr));
    }
}
