package Solution500_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1356 {
    private long countOne(int input){
        int ret = 0;
        int tmp = 1;
        while (tmp < input){
            ret += (input & tmp) != 0 ? 1 : 0;
            tmp = tmp << 1;
        }
        return ret;
    }

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length*3/2);
        for (int i = 0; i < arr.length; i++) {
            list.add((Integer.bitCount(arr[i]) << 20) + arr[i]);
        }
        list.sort(Integer::compareTo);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(list.get(i) & 0xfffff);
        }
        return arr;
    }

    public int[] sortByBits2(int[] arr) {
        for (int i = 0; i+3 < arr.length; i+=4) {
            arr[i+0] = (Integer.bitCount(arr[i+0]) << 20) + arr[i+0];
            arr[i+1] = (Integer.bitCount(arr[i+1]) << 20) + arr[i+1];
            arr[i+2] = (Integer.bitCount(arr[i+2]) << 20) + arr[i+2];
            arr[i+3] = (Integer.bitCount(arr[i+3]) << 20) + arr[i+3];
        }
        for (int i = arr.length-arr.length%4; i < arr.length; i++) {
            arr[i+0] = (Integer.bitCount(arr[i+0]) << 20) + arr[i+0];
        }
        Arrays.sort(arr);

        for (int i = 0; i+3 < arr.length; i+=4) {
            arr[i+0] &= 0xfffff;
            arr[i+1] &= 0xfffff;
            arr[i+2] &= 0xfffff;
            arr[i+3] &= 0xfffff;
        }
        for (int i = arr.length-arr.length%4; i < arr.length; i++) {
            arr[i+0] &= 0xfffff;
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
