package Solution100_150;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[10000];
        int stackSize = 0;

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+":
                    stackSize -= 2;
                    stack[stackSize] = stack[stackSize] + stack[stackSize + 1];
                    break;
                case "-":
                    stackSize -= 2;
                    stack[stackSize] = stack[stackSize] - stack[stackSize + 1];
                    break;
                case "*":
                    stackSize -= 2;
                    stack[stackSize] = stack[stackSize] * stack[stackSize + 1];
                    break;
                case "/":
                    stackSize -= 2;
                    stack[stackSize] = stack[stackSize] / stack[stackSize + 1];
                    break;
                default:
                    stack[stackSize] = Integer.valueOf(tokens[i]);
                    break;
            }
            stackSize++;
        }
        return stack[--stackSize];
    }
}
