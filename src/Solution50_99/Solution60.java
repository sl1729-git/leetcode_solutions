package Solution50_99;

import java.util.Arrays;

public class Solution60 {
    public String getPermutation(int n, int k) {
        assert n >= 1 && n <= 9 && k >= 1;
        StringBuffer ret = new StringBuffer();
        int[] splitLength = new int[n+1];
        splitLength[0] = splitLength[1] = 1;
        for (int i = 2; i <= n; i++) {
            splitLength[i] = splitLength[i-1] * i;
        }
        int currentIndex = 0;
        boolean[] numUsed = new boolean[n];
        Arrays.fill(numUsed, false);
        for (int i = 0; i < n; i++) {
            currentIndex = (k-1) / splitLength[n-i-1];
            int currentNum = -1;
            for (int j = 0; j <= currentIndex;) {
                if (!numUsed[++currentNum])
                    j++;
            }
            numUsed[currentNum] = true;
            ret.append(currentNum+1);
            k -= currentIndex * splitLength[n-i-1];
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution60 s= new Solution60();
        System.out.println(s.getPermutation(3,6));
    }
}
