package Solution500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution959 {
    class UnionFind{
        private int[] father;
        private int[] rank;

        public UnionFind(int n){
            this.father = new int[n];
            this.rank = new int[n];
            Arrays.fill(rank, 0);
            for (int i = 0; i < n; i++) {
                this.father[i] = i;
            }
        }

        public void merge(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            if (rank[rootX] < rank[rootY])
                father[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                father[rootY] = rootX;
            else {
                father[rootX] = rootY;
                rank[rootY] ++;
            }
        }

        public int find(int x){
            return (x == father[x]) ? x : (father[x] = find(father[x]));
        }

        public int[] getFather() {
            return father;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(4 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (j < n - 1){
                    unionFind.merge(idx * 4 + 3, (idx + 1) * 4);
                }
                if (i < n - 1){
                    unionFind.merge(idx * 4 + 2, (idx + n) * 4 + 1);
                }
                char tmp = grid[i].charAt(j);
                if (tmp == '\\'){
                    unionFind.merge(idx * 4, idx * 4 + 2);
                    unionFind.merge(idx * 4 + 1, idx * 4 + 3);
                }else if (tmp == '/'){
                    unionFind.merge(idx * 4, idx * 4 + 1);
                    unionFind.merge(idx * 4 + 2, idx * 4 + 3);
                }else {
                    unionFind.merge(idx * 4, idx * 4 + 1);
                    unionFind.merge(idx * 4 + 1, idx * 4 + 2);
                    unionFind.merge(idx * 4 + 2, idx * 4 + 3);
                }
            }
        }
        Set<Integer> group = new HashSet<>();
        int size = unionFind.getFather().length;
        for (int i = 0; i < size; i++) {
            group.add(unionFind.find(i));
        }

        return group.size();
    }

    public static void main(String[] args) {
        String[] grid = new String[]{" /","/ "};
        Solution959 s = new Solution959();
        System.out.println(s.regionsBySlashes(grid));
    }
}
