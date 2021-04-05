public class Solution327 {

    private int solution(int[] sums, int lower, int upper, int left, int right){
        int ret = 0;
        if (left == right)
            return ret;

        int mid = (left + right)/2;
        int n1 = solution(sums, lower, upper, left, mid);
        int n2 = solution(sums, lower, upper, mid, right);
        ret += n1 + n2;

        int l = 0, r = 0;
        for (int i = left; i < right; i++) {

        }
        return 0;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int ret = 0;


        return ret;
    }

}
