package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution1442 {
    public int solutionBad(int[] arr) {
        int ret = 0;
        if (arr == null || arr.length <= 1)
            return ret;
        int a = 0, b = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                a = arr[i];
                b = 0;
                for (int k = i + 1; k <= j; k++) {
                    b ^= arr[k];
                }
                for (int k = i + 1; k <= j; k++) {
                    if (a == b)
                        ret ++;
//                        System.out.println("("+i+","+k+","+j+")");
                    a ^= arr[k];
                    b ^= arr[k];
                }
            }
        }


        return ret;
    }

    public int countTriplets(int[] arr){
        int ret = 0;
        int[] s = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            s[i + 1] = s[i] ^ arr[i];
        }

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> total = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (count.containsKey(s[i + 1]))
                ret += count.get(s[i + 1]) * i - total.get(s[i + 1]);

            count.put(s[i], count.getOrDefault(s[i], 0) + 1);
            total.put(s[i], total.getOrDefault(s[i], 0) + i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,6,7};
        Solution1442 s = new Solution1442();
        System.out.println(s.countTriplets(arr));
    }
}
