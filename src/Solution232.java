public class Solution232 {
}

class MyQueue {
    private int[] stack1 = new int[200];
    private int[] stack2 = new int[200];
    private int stack1Point = 0, stack2Point = 0;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1[stack1Point++] = x;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2Point == 0){
            while (stack1Point > 0)
                stack2[stack2Point++] = stack1[--stack1Point];
        }
        return stack2[--stack2Point];
    }

    /** Get the front element. */
    public int peek() {
        if (stack2Point == 0){
            while (stack1Point > 0)
                stack2[stack2Point++] = stack1[--stack1Point];
        }
        return stack2[stack2Point-1];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2Point + stack1Point == 0;
    }
}