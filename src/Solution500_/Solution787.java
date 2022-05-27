package Solution500_;


import java.util.*;

public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n <= 0 || flights == null || k < 0 || src < 0 || dst < 0)
            return -1;

        Map<Integer, List<int[]>> graphEdge = new HashMap<>();
        for (int[] edge:flights) {
            List<int[]> edges = graphEdge.getOrDefault(edge[0], new ArrayList<>());
            edges.add(edge);
            graphEdge.put(edge[0], edges);
        }

        int[][] costAndJump = new int[2][n];
        Arrays.fill(costAndJump[0], Integer.MAX_VALUE);
        costAndJump[0][src] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        Set<int[]> edgeUsed = new HashSet<>();

        queue.addAll(graphEdge.getOrDefault(src, new ArrayList<>()));
        while (!queue.isEmpty()){
            int[] minEdge = queue.poll();
            edgeUsed.add(minEdge);
            int useCurrentEdgeCost = minEdge[2] + costAndJump[0][minEdge[0]];
            if (costAndJump[1][minEdge[0]] <= k && useCurrentEdgeCost < costAndJump[0][minEdge[1]]){
                costAndJump[1][minEdge[1]] = costAndJump[1][minEdge[0]] + 1;
                costAndJump[0][minEdge[1]] = useCurrentEdgeCost;
                for (int[] edge:graphEdge.getOrDefault(minEdge[1], new ArrayList<>())) {
                    if (!edgeUsed.contains(edge))
                        queue.add(edge);
                }
            }
        }

        return costAndJump[0][dst] == Integer.MAX_VALUE ? -1 : costAndJump[0][dst];
    }

    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {0,1,1},{0,2,5},{1,2,1},{2,3,1}
        };
        int n = 4, src = 0, dst = 3, k = 1;
        Solution787 s = new Solution787();
        System.out.println(s.findCheapestPrice(n, flights, src, dst, k));
    }
}
