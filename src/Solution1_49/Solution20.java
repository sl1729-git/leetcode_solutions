package Solution1_49;

import java.util.ArrayList;
import java.util.List;

public class Solution20 {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        if (s.length() > 0 && (s.charAt(0) == ')' || s.charAt(0) == ']'|| s.charAt(0) == '}')){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            if (stack.size() > 1){
                char tmp1 = stack.get(stack.size()-2), tmp2 = stack.get(stack.size()-1);
                if (tmp2-tmp1 == 1 || tmp2-tmp1==2){
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
//                else if (stack.get(stack.size()-1) > stack.get(stack.size()-2)){
//                    return false;
//                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.isValid("{()}"));
    }
}
