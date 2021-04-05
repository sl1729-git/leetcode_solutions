package Solution500_;

public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 2)
            return true;
        int diffY = coordinates[coordinates.length - 1][1] - coordinates[0][1];
        int diffX = coordinates[coordinates.length - 1][0] - coordinates[0][0];
        for (int i = 1; i < coordinates.length - 1; i++) {
            int tmpDiffX = coordinates[i][0] - coordinates[0][0];
            int tmpDiffY = coordinates[i][1] - coordinates[0][1];
            if (tmpDiffX * diffY != tmpDiffY * diffX)
                return false;
        }
        return true;
    }
}
