package Solution500_;

import java.util.ArrayList;
import java.util.List;

public class Solution842 {
    private boolean solution(List<Integer> stack, int index, int length, int sum, int prev, String S){
        if (index == length)
            return stack.size() > 2;
        long current = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0')
                break;
            current = current * 10 + S.charAt(i) - '0';
            if (current > Integer.MAX_VALUE)
                break;
            int curr = (int)current;
            if (stack.size() >= 2){
                if (curr < sum)
                    continue;
                else if (curr > sum)
                    break;
            }
            stack.add(curr);
            if (solution(stack, i + 1, length, prev + curr, curr, S))
                return true;
            else
                stack.remove(stack.size()-1);
        }
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<>();
        solution(ret, 0, S.length(), 0,0,  S);
        return ret;
    }

    public static void main(String[] args) {
        String S = "123456579";
        Solution842 s= new Solution842();
        System.out.println(s.splitIntoFibonacci(S));
    }
}
