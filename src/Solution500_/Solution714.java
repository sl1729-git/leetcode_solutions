package Solution500_;

public class Solution714 {
    public int solutionWrong(int[] prices, int fee) {
        assert prices != null && fee >= 0;
        int ret = 0;
        if (prices.length <= 1)
            return ret;
        int[] priceState = new int[prices.length];
//        1 means top, -1 mean bottom
        priceState[0] = Integer.compare(prices[0], prices[1]);
        priceState[priceState.length-1] = Integer.compare(prices[prices.length-1]-fee, prices[prices.length-2]);
        for (int i = 1; i < prices.length-1; i++) {
            priceState[i] = (prices[i] > prices[i-1] && prices[i] > prices[i+1]) ? 1 :
                    (prices[i] < prices[i-1] && prices[i] < prices[i+1] ? -1 : 0);
        }
        int buyIndex = 0, income = -1;
        boolean takeStoke = false;
        for (int i = 0; i < priceState.length; i++) {
            if (priceState[i] == -1){
                buyIndex = prices[i] < prices[buyIndex] || !takeStoke ? i : buyIndex;
                takeStoke = true;
            }else if (takeStoke && priceState[i] == 1){
                income = prices[i] - prices[buyIndex] - fee;
                ret += income > 0 ? income : 0;
                takeStoke = !(income > 0);
            }
        }
        return ret;
    }

    public int maxProfit(int[] prices, int fee) {
        assert prices != null && fee >= 0;
        int ret = 0;
        if (prices.length <= 1)
            return ret;
        int carry = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < carry)
                carry = prices[i];
            else if (prices[i] - fee > carry){
                ret += (prices[i] - fee) - carry;
                carry = prices[i] - fee;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,7,5,10,3};
        Solution714 s = new Solution714();
        System.out.println(s.maxProfit(prices,3));
    }
}
