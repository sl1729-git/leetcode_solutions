package Solution1_49;

import java.util.ArrayList;
import java.util.List;

public class Solution32 {
    private class Item{
        int index;
        char aChar;

        public Item(int index, char aChar) {
            this.index = index;
            this.aChar = aChar;
        }
    }

    public int longestValidParentheses(String s) {
        int ret = 0;
        if (s == null || s.length() <= 1)
            return ret;
        List<Item> stack = new ArrayList<>();
        stack.add(new Item(-1, '$'));
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(')
                stack.add(new Item(i, currentChar));
            else{
                if (stack.get(stack.size()-1).aChar == '(')
                    stack.remove(stack.size()-1);
                else
                    stack.add(new Item(i, currentChar));
            }
        }
        stack.add(new Item(s.length(),'$'));
        int tmp = 0;
        for (int i = 1; i < stack.size(); i++) {
            tmp = stack.get(i).index - stack.get(i-1).index;
            ret = ret < tmp ? tmp : ret;
        }
        return ret-1;
    }

    public static void main(String[] args) {
        Solution32 s = new Solution32();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}
