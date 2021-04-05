package Solution500_;

public class Solution940 {
    public int distinctSubseqII(String S) {
        int mod = 1000_000_000 + 7;
        long[] dp = new long[S.length() + 1];
        int[] last = new int[26];

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int tmp = S.charAt(i - 1) - 'a';
            dp[i] = (((2 * dp[i - 1]) % mod) - (last[tmp] > 0 ? dp[last[tmp] - 1] : 0)) % mod;
            last[tmp] = i;
        }

        dp[S.length()] --;
        return (int)(dp[S.length()] < 0 ? dp[S.length()] + mod : dp[S.length()]);
    }

    public static void main(String[] args) {
        String S = "trmnysxnqebcexbadivzlydqreqzxxnegygoddmhiywgfdlbomkauddngxrolekxdchoimomztkfdobtjwdomdrouyuvpmafqkvi";
        Solution940 s = new Solution940();
        System.out.println(s.distinctSubseqII(S));
    }
}
