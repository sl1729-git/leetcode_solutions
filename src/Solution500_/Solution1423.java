package Solution500_;

public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret += cardPoints[i];
        }
        int currentPoints = ret;
        for (int i = 0; i < k; i++) {
            currentPoints += cardPoints[cardPoints.length - 1 - i] - cardPoints[k - 1 -i];
            ret = Math.max(ret, currentPoints);
        }

        return ret;
    }
}
