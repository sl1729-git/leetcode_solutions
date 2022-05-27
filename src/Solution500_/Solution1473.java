package Solution500_;

public class Solution1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if (houses.length < target || (target > 1 && n == 1))
            return -1;
        int[][] dp = new int[n][m];
        int[][] neighborhoodCount = new int[n][m];
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == 0)
                continue;
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE / 4 - 1;
            }
            cost[i][houses[i] - 1] = 0;
        }
        int preMin = 0;
        int currentMin = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = cost[0][i];
            neighborhoodCount[i][0] = 1;
            preMin = dp[i][0] < dp[preMin][0] ? i : preMin;
        }

        for (int i = 1; i < houses.length; i++) {
            for (int j = 0; j < n; j++) {
                currentMin = 0;
                dp[j][i] = neighborhoodCount[preMin][i - 1] == target ?
                        dp[j][i - 1] + cost[i][preMin] : dp[preMin][i - 1] + cost[i][j];
                neighborhoodCount[j][i] = neighborhoodCount[preMin][i - 1] == target ?
                        target : (preMin == j ? neighborhoodCount[j][i -1] :
                        neighborhoodCount[preMin][i - 1] + 1);
                currentMin = dp[j][i] < dp[currentMin][i] ? j : currentMin;
            }
            preMin = currentMin;
        }

        return dp[currentMin][m - 1];
    }

    public static void main(String[] args) {
        int[] houses = new int[]{0,2,1,2,0};
        int[][] cost = new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}};
        Solution1473 s = new Solution1473();
        System.out.println(s.minCost(houses, cost, 5, 2, 3));
    }
}
