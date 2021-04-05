package Solution500_;

public class Solution1006 {
    public int clumsy(int N) {
        assert N > 0;
        if (N <= 2)
            return N;
        int op = 2;
        int[] stack = new int[2];
        stack[0] = N * (N -1) / (N - 2);
        for (int i = N - 3; i > 0; i--) {
            switch (op % 4){
                case 0:
                    stack[1] *= i;
                    break;
                case 1:
                    stack[1] /= i;
                    stack[0] -= stack[1];
                    stack[1] = 0;
                    break;
                case 2:
                    stack[0] += i;
                    break;
                case 3:
                    stack[1] = i;
                    break;
            }
            op ++;
        }
        return stack[0] - stack[1];
    }

    public static void main(String[] args) {
        Solution1006 s = new Solution1006();
        System.out.println(s.clumsy(7));
    }
}
