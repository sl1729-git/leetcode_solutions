package Solution500_;

import java.util.*;

public class Solution815 {


    /**
     * 本质就是广搜，再优化就是双向搜索，或者用树+并查集去做
     * @param routes 公交线路，必须是每一站都是正数
     * @param source 原点，必须是大于0的正数
     * @param target 目标点
     * @return 如果不可能到达，则返回-1；否则返回最小换乘数
     */
    public int solutionSlow(int[][] routes, int source, int target) {
        if (routes == null || routes.length == 0)
            return -1;

        int max = routes[0][0];
        for (int[] route:routes) {
            max = Math.max(Arrays.stream(route).max().getAsInt(), max);
        }
        //如果目标点大于最远的站，显然不可到达
        if (target > max)
            return -1;

        //这一块是优化计算代价，用HashMap减少遍历次数
        int[] minCost = new int[max + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[source] = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] route : routes) {
            for(int stop:route){
                if (!map.containsKey(stop))
                    map.put(stop, new ArrayList<>());
                map.get(stop).add(route);
            }
        }

        Set<int[]> uncheck = new HashSet<>();
        uncheck.addAll(Arrays.asList(routes));

        List<Integer> quene = new ArrayList<>();
        quene.add(source);
        int current = 0;
        //每一次都把当前站点的所有途径且没有搭乘的车都计算一下
        while (!uncheck.isEmpty() && !quene.isEmpty()){
            current = quene.remove(0);
            List<int[]> route = map.get(current);
            for (int[] currentCheck:route) {
                if (!uncheck.contains(currentCheck))
                    continue;
                for (int stop:currentCheck) {
                    if (minCost[stop] < Integer.MAX_VALUE)
                        continue;
                    minCost[stop] = minCost[current] + 1;
                    quene.add(stop);
                }
                uncheck.remove(currentCheck);
            }
        }

        return minCost[target] == Integer.MAX_VALUE ? -1 : minCost[target];
    }
}
