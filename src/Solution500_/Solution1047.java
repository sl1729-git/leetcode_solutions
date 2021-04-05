package Solution500_;

public class Solution1047 {
    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char tmp = S.charAt(i);
            if (top < 0 || stack[top] != tmp)
                stack[++top] = tmp;
            else
                top--;
        }

        return new String(stack, 0, ++top);
    }
}
