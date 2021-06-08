package Solution151_300;

import java.util.Arrays;
import java.util.Stack;

public class Solution155 {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

/**
 * 使用标准库的Stack实现
 * stack模拟普通栈，minIndex单调栈，记录一个单调递减的序列，其存储stack中的index，使得minIndex中的后进入
 * index对应的值总是小于之前index对应的值，这样其栈顶的index就是栈中最小值index
 */
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minIndex = new Stack<>();
    private int size = 0;
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        size++;
        if (minIndex.isEmpty() || stack.get(minIndex.peek()) >= val)
            minIndex.push(size - 1);
    }

    public void pop() {
        stack.pop();
        size--;
        if (!minIndex.isEmpty() && minIndex.peek() == size)
            minIndex.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.get(minIndex.peek());
    }
}

/**
 * 将上面的方法选择用int数组模拟，容量不够自动倍增
 */
class MinStack2 {
    private int[] stack = new int[1024];
    private int[] minIndex = new int[1024];
    private int sizeStack = 0;
    private int sizeMinIndex = 0;
    public MinStack2() {

    }

    public void push(int val) {
        if (sizeStack == stack.length)
            stack = Arrays.copyOf(stack, stack.length * 2);
        if (sizeMinIndex == minIndex.length)
            minIndex = Arrays.copyOf(minIndex, minIndex.length * 2);
        stack[sizeStack++] = val;
        if (sizeMinIndex == 0 || stack[minIndex[sizeMinIndex-1]] >= val)
            minIndex[sizeMinIndex++] = sizeStack - 1;
    }

    public void pop() {
        sizeStack--;
        if (sizeMinIndex > 0 && minIndex[sizeMinIndex - 1] == sizeStack)
            sizeMinIndex--;
    }

    public int top() {
        return stack[sizeStack - 1];
    }

    public int getMin() {
        return stack[minIndex[sizeMinIndex-1]];
    }
}