package Solution500_;

import java.util.*;

public class Solution1190 {
    public String reverseParentheses(String s) {
        char[] S = s.toCharArray();
        int[] pair = new int[S.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length; i++) {
            char current = S[i];
            if (current == '(')
                stack.push(i);
            else if (current == ')'){
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder ret = new StringBuilder();
        int index = 0, step = 1;
        while (index < S.length){
            char current = S[index];
            if (current == '(' || current == ')'){
                index = pair[index];
                step = -step;
            }else
                ret.append(current);

            index += step;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String S = "(u(love)i)";
        Solution1190 s = new Solution1190();
        System.out.println(s.reverseParentheses(S));
    }
}
