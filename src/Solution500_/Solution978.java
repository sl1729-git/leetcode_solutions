package Solution500_;

public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        assert arr != null && arr.length > 0 && arr.length <= 40000;
        int ret = 0;
        int left = 0, right = 1;
        boolean state;
        while (right < arr.length){
            if (arr[right] == arr[left]){
                left ++;
                right ++;
                continue;
            }
            state = arr[right] > arr[left];
            while (right + 1 < arr.length){
                if (arr[right] == arr[right+1])
                    break;
                if (state && arr[right+1] > arr[right])
                    break;
                if (!state && arr[right] > arr[right+1])
                    break;
                state = !state;
                right++;
            }
            ret = Math.max(ret, right - left);
            left = right++;
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,4,2,10,7,8,8,1,9};
        Solution978 s = new Solution978();
        System.out.println(s.maxTurbulenceSize(arr));
    }
}
