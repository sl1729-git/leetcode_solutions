package Solution500_;

import java.util.Arrays;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (unionFind.union(edges[i][0], edges[i][1]))
                return edges[i];
        }

        return null;
    }
}

class UnionFind{
    private int[] father;
    private int[] rank;

    public UnionFind(int n){
        father = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return true;
    
        if (rank[rootX] == rank[rootY]){
            rank[rootY]++;
            father[rootX] = rootY;
        }else if (rank[rootX] < rank[rootY]){
            father[rootX] = rootY;
        }else 
            father[rootY] = rootX;
        return false;
    }

    public int find(int x){
        return (x == father[x]) ? x : (father[x] = find(father[x]));
    }

    public boolean isSameGroup(int x, int y){
        return find(x) == find(y);
    }


}
