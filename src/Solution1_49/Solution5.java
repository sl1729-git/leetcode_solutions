package Solution1_49;

import java.util.Arrays;

public class Solution5 {
    public String solution1(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int indexStart = 0, indexEnd = 0, maxLength = 0;
        for (int loop = 0; loop < n; loop++) {
            for (int i = 0; i + loop < n; i++) {
                int j = i + loop;
                if(loop == 0){
                    dp[i][i] = true;
                }else if (loop == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && maxLength < (j - i)){
                    maxLength = j - i;
                    indexStart = i;
                    indexEnd   = j;
                }
            }
        }
        return s.substring(indexStart, indexEnd + 1);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        if (n == 0){
            return "";
        }else if (n == 1) {
            return s;
        }else if (n == 2){
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);
        }
        for (int i = n/2-1; i < n; i++) {
            for (int j = 1; j < n-i-1; j++) {
                if (s.charAt(i-j) == s.charAt(i+j)){
                    dp[i]++;
                }else{
                    continue;
                }
            }
        }
        System.out.println(1111);

        return "";
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String s = "bccb";
        System.out.println(solution5.longestPalindrome(s));
    }
}
