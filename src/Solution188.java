import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0)
            return 0;
        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, -prices[0]);
        Arrays.fill(sells, 0);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                int tmp = (j == 0) ? 0 : sells[j-1];
                buys[j] = Math.max(buys[j], tmp-prices[i]);
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k-1];
    }
}
