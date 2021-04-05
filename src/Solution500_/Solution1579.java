package Solution500_;

import java.util.Arrays;

public class Solution1579 {
    class UnionFind{
        private int[] father;
        private int[] rank;

        public UnionFind(int n){
            father = new int[n];
            rank = new int[n];
            Arrays.fill(rank,0);
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x){
            return (x == father[x]) ? x : (father[x] = find(father[x]));
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return true;

            if (rank[rootX] < rank[rootY])
                father[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                father[rootY] = rootX;
            else {
                father[rootX] = rootY;
                rank[rootY] ++;
            }
            return false;
        }

        public UnionFind copy(){
            UnionFind ret = new UnionFind(father.length);
            ret.rank = Arrays.copyOf(rank, rank.length);
            ret.father = Arrays.copyOf(father, father.length);
            return ret;
        }
    }

    public int solve(UnionFind group, int[][] edges, int type){
        int ret = 0;
        for (int[] edge:edges) {
            if (edge[0] != type)
                continue;
            if (group.union(edge[1], edge[2]))
                ret ++;
        }

        for (int i = 0; i < group.father.length; i++) {
            group.find(i);
        }

        for (int i = 1; i < group.father.length; i++) {
            if (group.father[i] != group.father[i-1])
                return -1;
        }

        return ret;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind publicGroup = new UnionFind(n + 1);
        publicGroup.union(0, 1);
        int ret = 0;
        for (int[] edge:edges) {
            if (edge[0] != 3)
                continue;
            if (publicGroup.union(edge[1], edge[2]))
                ret ++;
        }

        UnionFind alice = publicGroup.copy();
        UnionFind bob = publicGroup;
        int tmp = 0;
        tmp = solve(alice, edges, 1);
        if (tmp == -1)
            return -1;
        ret += tmp;
        tmp = solve(bob, edges, 2);
        if (tmp == -1)
            return -1;
        ret += tmp;
        return ret;
    }
}
