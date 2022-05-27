package Solution500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1883 {
    public int maxIceCream(int[] costs, int coins) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int cost:costs) {
            count.put(cost, count.getOrDefault(cost, 0) + 1);
        }
        int[][] pairs = new int[count.size()][2];
        int index = 0;
        for (Integer cost:count.keySet()) {
            pairs[index][0] = cost;
            pairs[index++][1] = count.get(cost);
        }
        Arrays.sort(pairs, (o1, o2)->Integer.compare(o1[0],o2[0]));
        int ret = 0;
        index = 0;
        while (index < pairs.length && coins > 0){
            int currentCost = pairs[index][0];
            int currentCount = pairs[index++][1];
            int canBuy = Math.min(coins / currentCost, currentCount);
            coins -= canBuy * currentCost;
            ret += canBuy;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{4,7,6,4,4,2,2,4,8,8};
        int coins = 41;
        Solution1883 s = new Solution1883();
        System.out.println(s.maxIceCream(costs, coins));
    }
}
