package Solution500_;

public class Solution633 {
    private boolean solution1(int c){
        int left = 0, right = 0;
        while (left <= right){
            int left_sqrt = left * left;
            right = (int)Math.sqrt(c - left * left);
            if (left_sqrt + right * right == c)
                return true;
            left ++;
            right ++;
        }

        return false;
    }

    /**
     * 数学的方式
     * @param c A num bigger or equal than 0
     * @return true if there is (a,b) makes a^2 + b^2 = c, other false
     */
    private boolean solution2(int c){
        for (int i = 2; i * i <= c; i++) {
            if (c % i != 0)
                continue;
            int exp = 0;
            while (c % i == 0){
                c /= i;
                exp ++;
            }

            if (i % 4 == 3 && exp % 2 != 0)
                return false;
        }

        return (c % 4) != 3;
    }

    public boolean judgeSquareSum(int c) {
        return solution2(c);
    }

    public static void main(String[] args) {
        Solution633 s = new Solution633();
        System.out.println(s.judgeSquareSum(6));
    }
}
