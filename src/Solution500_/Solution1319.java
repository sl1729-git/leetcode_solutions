package Solution500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1319 {
    private class UnionFind{
        int[] father;
        int[] rank;

        public UnionFind(int n){
            father = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (rank[rootX] < rank[rootY]){
                father[rootX] = rootY;
            }else if (rank[rootX] > rootY){
                father[rootY] = rootX;
            }else {
                father[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public int find(int x){
            return (x == father[x]) ? x : (father[x] = find(father[x]));
        }

        public int[] getFather() {
            return father;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int ret = -1;
        UnionFind unionFind = new UnionFind(n);
        for (int[] connect:connections) {
            unionFind.union(connect[0],connect[1]);
        }
        for (int i = 0; i < n; i++) {
            unionFind.find(i);
        }
        Set<Integer> tmp = new HashSet<>(Arrays.stream(unionFind.getFather()).boxed().collect(Collectors.toList()));
        ret = connections.length < n -1 ? -1 : tmp.size() - 1;
        return ret;
    }
}
