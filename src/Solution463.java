public class Solution463 {

    private int getPerimetre(int[][] grid, int x, int y){
        if (grid[x][y] == 0)
            return 0;
        int ret = 0;
        ret += (x < grid.length-1) ? (grid[x+1][y] == 0 ? 1 : 0) :
                ((x == grid.length-1) ? 1 : 0);
        ret += (x > 0) ? (grid[x-1][y] == 0 ? 1 : 0) :
                ((x == 0) ? 1 : 0);
        ret += (y < grid[x].length-1) ? (grid[x][y+1] == 0 ? 1 : 0) :
                ((y == grid[x].length-1) ? 1 : 0);
        ret += (y > 0) ? (grid[x][y-1] == 0 ? 1 : 0) :
                ((y == 0) ? 1 : 0);
        return ret;
    }

    public int islandPerimeter(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ret += getPerimetre(grid, i, j);
            }
        }
        return ret;
    }
}
