package Solution301_499;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution403 {

    private boolean solution(int[] stones){
        if (stones == null || stones.length <= 1)
            return true;
        if (stones[1] > 1)
            return false;

        Stack<int[]> stack = new Stack<>();
        int[] start = new int[]{1,1};
        stack.push(start);

        while (!stack.isEmpty()){
            int[] node = stack.pop();
            if (node[0] == stones.length - 1)
                return true;
            int maxJump = node[1] + 1;
            int minJump = Math.max(node[1] - 1, 0);
            for (int i = node[0] + 1; i < stones.length; i++) {
                int jump = stones[i] - stones[node[0]];
                if (jump >= minJump && jump <= maxJump)
                    stack.push(new int[]{i, jump});
                else if (jump > maxJump)
                    break;
            }
        }

        return false;
    }

    public boolean canCross(int[] stones) {
        return solution(stones);
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,6,10,15,16,21};
        Solution403 s = new Solution403();
        System.out.println(s.canCross(stones));
        Queue<Integer> queue = new PriorityQueue<>();

    }
}
