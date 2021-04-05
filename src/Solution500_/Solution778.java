package Solution500_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution778 {
    class UnionFind{
        private int[] father;
        private int[] rank;

        public UnionFind(int n){
            assert n >= 0;
            father = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 0);
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
                return false;

            if (rank[rootX] < rank[rootY])
                father[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                father[rootY] = rootX;
            else {
                father[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }

    private void add(int[][] grid, UnionFind union,int row, int col){
        int currentHeight = grid[row][col];
//        if (col > 0 && row > 0 && grid[row - 1][col - 1] < currentHeight)
//            union.union(grid[row-1][col-1], currentHeight);
        if (col > 0 && grid[row][col - 1] < currentHeight)
            union.union(grid[row][col - 1], currentHeight);
        if (row > 0 && grid[row - 1][col] < currentHeight)
            union.union(grid[row - 1][col], currentHeight);
//        if (row > 0 && col + 1 < grid[row].length && grid[row - 1][col + 1] < currentHeight)
//            union.union(grid[row - 1][col + 1], currentHeight);
        if (col + 1 < grid[row].length && grid[row][col + 1] < currentHeight)
            union.union(grid[row][col + 1], currentHeight);
//        if (row + 1 < grid.length && col + 1 < grid[row + 1].length && grid[row + 1][col + 1] < currentHeight)
//            union.union(grid[row + 1][col + 1], currentHeight);
        if (row + 1 < grid.length && grid[row + 1][col] < currentHeight)
            union.union(grid[row + 1][col], currentHeight);
//        if (row + 1 < grid.length && col > 0 && grid[row + 1][col - 1] < currentHeight)
//            union.union(grid[row + 1][col - 1], currentHeight);
    }

    public int swimInWater(int[][] grid) {
        int ret = 0;
        int endHeight = grid[grid.length - 1][grid[grid.length - 1].length - 1];
        Map<Integer, int[]> height2pos = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                height2pos.put(grid[i][j], new int[]{i, j});
            }
        }
        int maxHeight = grid.length * grid[0].length;
        UnionFind union = new UnionFind(maxHeight);
        for (int i = 0; i < maxHeight; i++) {
            int[] pos = height2pos.get(i);
            int col = pos[1];
            int row = pos[0];
            add(grid, union, row, col);
            if (union.find(grid[0][0]) == union.find(endHeight))
                return i;
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11}
//        }
    }

}
