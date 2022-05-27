package Solution500_;

public class Solution678 {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        for (char c:s.toCharArray()) {
            if (c == '('){
                minCount ++;
                maxCount ++;
            }else if (c == '*'){
                minCount = Math.max(minCount - 1, 0);
                maxCount ++;
            }else if (c == ')'){
                minCount = Math.max(minCount - 1, 0);
                maxCount --;
                if (maxCount < 0)
                    return false;
            }else
                return false;
        }

        return minCount == 0;
    }

    public static void main(String[] args) {
        String S = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

    }
}
