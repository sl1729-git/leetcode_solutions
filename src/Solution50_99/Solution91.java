package Solution50_99;

public class Solution91 {
    private int solutionWrong(String s){
        int ret = 0;
        if (s == null || s.length() == 0)
            return ret;
        if (s.length() >= 2 && (s.charAt(0) == '1' ||
                (s.charAt(0) == 2 && s.charAt(1) <= '6')))
            ret += solutionWrong(s.substring(1)) + solutionWrong(s.substring(2)) + 1;
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;
        return ret;
    }

    private int solutionWrong2(String s, int index){
        assert index >= 0;
        int ret = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                return ret;
            else if (i+1 < s.length() && (s.charAt(i) == '1' ||
                    (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
                ret += 1 + solutionWrong2(s, i+2);
            else
                return ret;
        }
        return ret;
    }

    private int solution(String s){
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        char[] code = s.toCharArray();
        int[][] dp = new int[2][code.length];
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = (s.charAt(i) != '0' ? dp[0][i-1]+dp[1][i-1] : 0);
            dp[1][i] = ((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6') ? dp[0][i-1] : 0);
        }
        return dp[0][dp[0].length-1] + dp[1][dp[1].length-1];
    }

    public int numDecodings(String s) {
        return solution(s);
    }

    public static void main(String[] args) {
        Solution91 s = new Solution91();
        System.out.println(s.numDecodings("226"));
    }
}
