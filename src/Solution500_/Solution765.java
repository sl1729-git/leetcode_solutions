package Solution500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution765 {
    class UnionFind{
        private int[] father;
        private int[] rank;
        private int size;

        public UnionFind(int n){
            assert n >= 0;
            this.father = new int[n];
            this.rank = new int[n];
            this.size = n;
            Arrays.fill(this.rank, 1);
            for (int i = 0; i < n; i++) {
                this.father[i] = i;
            }
        }

        public int find(int x){
            assert x < size;
            return (x == father[x]) ? x : (father[x] = find(father[x]));
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY]){
                father[rootX] = rootY;
            }else if (rank[rootX] > rank[rootY]){
                father[rootY] = rootX;
            }else {
                father[rootX] = rootY;
                rank[rootY] ++;
            }
            return true;
        }

        public int getSize() {
            return size;
        }
    }

    public void add(int index, int id, int[] id2index, UnionFind unionFind){
        if (id % 2 == 0){
            unionFind.union(index/2, id2index[id + 1]/2);
        }else {
            unionFind.union(index/2, id2index[id - 1]/2);
        }
    }

    public int minSwapsCouples(int[] row) {
        int ret = 0;
        int[] id2index = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            id2index[row[i]] = i;
        }
        UnionFind unionFind = new UnionFind(row.length/2);
        for (int i = 0; i < row.length; i+=2) {
            if (row[i]/2 == row[i+1]/2)
                continue;
            add(i, row[i], id2index, unionFind);
            add(i + 1, row[i + 1], id2index, unionFind);
        }
        Set<Integer> groupCount = new HashSet<>();
        for (int i = 0; i < unionFind.getSize(); i++) {
            groupCount.add(unionFind.find(i));
        }
        return unionFind.getSize() - groupCount.size();
    }

    public static void main(String[] args) {
        int[] row = new int[]{0,2,1,3};
        Solution765 s = new Solution765();
        System.out.println(s.minSwapsCouples(row));
    }
}
