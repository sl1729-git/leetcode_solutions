import java.util.Arrays;
import java.util.Stack;

public class Solution224 {

    private boolean[] opTable = new boolean[256];
    private int[] opPriority = new int[256];

    /**
     *
     * @param op1 第一个运算符
     * @param op2 第二个运算符
     * @return 第一个运算符与第二个的优先级关系，0表示同优先，小于0表示第二个优先级高，大于0表示第一个优先级高
     */
    private int opCompara(char op1, char op2){
        return opPriority[op1 & 0xff] - opPriority[op2 & 0xff];
    }

    private void initOpTable(){
        Arrays.fill(opTable, false);
        opTable['+'] = true;
        opTable['-'] = true;
        opTable['*'] = true;
        opTable['/'] = true;
        opTable['('] = true;
        opTable[')'] = true;

        Arrays.fill(opPriority, 0);
        opPriority['+'] = 1;
        opPriority['-'] = 1;
        opPriority['*'] = 2;
        opPriority['/'] = 2;
        opPriority['('] = Integer.MAX_VALUE / 2 - 1;
        opPriority[')'] = Integer.MAX_VALUE / 2 - 1;
    }

    private void popNum(Stack<Character> stack, StringBuffer buf){
        char currentChar = stack.pop();
        while (currentChar == ' ')
            currentChar = stack.pop();
        while (currentChar != ' '){
            buf.append(currentChar);
            currentChar = stack.pop();
        }
    }

    private String expressionTrans(String expression){
        initOpTable();
        Stack<Character> stack = new Stack<>();
        StringBuffer buf = new StringBuffer();
        expression = "(" + expression + ")";
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (opTable[currentChar & 0xff]){
                buf.append(' ');
                if (currentChar == ')'){
                    currentChar = stack.pop();
                    while (currentChar != '('){
                        buf.append(' ');
                        buf.append(currentChar);
                        buf.append(' ');
                        currentChar = stack.pop();
                    }
                }else if (!stack.empty()){
                    char preChar = stack.pop();
                    while (preChar != '(' && opCompara(currentChar, preChar) <= 0){
                        buf.append(' ');
                        buf.append(preChar);
                        buf.append(' ');
                        preChar = stack.pop();
                    }
                    stack.push(preChar);
                    stack.push(currentChar);
                }else
                    stack.push(currentChar);
            }else {
                buf.append(currentChar);
            }
        }

        return buf.toString();
    }

    private int getValue(int num1, int num2, char op){
        int ret = 0;
        switch (op){
            case '+' :
                ret = num1 + num2;
                break;
            case '-' :
                ret = num1 - num2;
                break;
            case '*' :
                ret = num1 * num2;
                break;
            case '/' :
                ret = num1 / num2;
                break;
            default :
                throw new RuntimeException("Unsupport op " + op);
        }
        return ret;
    }

    public int calculate(String s) {
        s = expressionTrans(s);
        String[] items = s.split(" +");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//第一个数如果是负数就可以正确运行
        for (int i = 0; i < items.length; i++) {
            if (items[i].length() == 0)
                continue;
            if (opTable[items[i].charAt(0) & 0xff]){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(getValue(num1, num2, items[i].charAt(0)));
            }else
                stack.push(Integer.valueOf(items[i]));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String test = "(1+(4+5+2)-3)+(6+8)";
        Solution224 s = new Solution224();
        System.out.println(s.calculate(test));
    }
}
