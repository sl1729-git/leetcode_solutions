package Solution500_;

public class Solution1894 {

    public int chalkReplacer(int[] chalk, int k) {
        assert k >= 0;
        if (k < chalk[0])
            return 0;

        for (int i = 1; i < chalk.length; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k)
                return i;
        }

        k = k % chalk[chalk.length - 1];
        int left = 0, right = chalk.length, mid;
        while (left < right){
            mid = (left + right) / 2;
            if (chalk[mid] > k)
                right = mid;
            else
                left = mid + 1;

        }

        return left;
    }
}
