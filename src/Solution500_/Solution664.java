package Solution500_;

import java.util.Arrays;

public class Solution664 {
    //todo:修改贪心算法到正确的方式
    public int solutionWrong(String s) {
        char[] input = s.toCharArray();
        char[] print = new char[input.length];
        int[] index = new int[26];
        for (int i = 0; i < input.length; i++) {
            index[input[i] - 'a'] = i;
        }

        int ret = 0;
        for (int i = 0; i < input.length; i++) {
            if (print[i] == input[i])
                continue;
            Arrays.fill(print, i, index[input[i] - 'a'] + 1, input[i]);
            ret ++;
        }

        return ret;
    }

    private int solutionDP(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int[] tmp:dp) {
            Arrays.fill(tmp,Integer.MAX_VALUE/2);
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp.length - i; j++) {
                if (s.charAt(j) == s.charAt(i + j)) {
                    dp[j][i + j] = dp[j][i + j - 1];
                }else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < i; k++) {
                        min = Math.min(min, dp[j][j + k] + dp[j + k + 1][i + j]);
                    }
                    dp[j][i + j] = min;
                }
            }
        }

        return dp[0][dp.length - 1];
    }

    public int strangePrinter(String s){
        return solutionDP(s);
    }

    public static void main(String[] args) {
        String S = "abcabcabc";
        Solution664 s = new Solution664();
        System.out.println(s.strangePrinter(S));
    }
}
