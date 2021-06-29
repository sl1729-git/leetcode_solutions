package Solution1_49;

import java.util.*;

public class Solution40 {
    class Node{
        int[] candidates;
        int index;
        int target;
        List<Integer> ans = new ArrayList<>();

        Node(int[] candidates, int index, int target, List<Integer> ans){
            this.candidates = candidates;
            this.index = index;
            this.target = target;
            this.ans.addAll(ans);
        }

        private void take(){
            if (this.index < this.candidates.length) {
                this.target -= candidates[this.index];
                this.ans.add(candidates[index++]);
            }else {
                this.target = -1;
            }
        }

        public Node getNextPlus1(){
            return new Node(candidates, index + 1, target, ans);
        }

        public Node getNextPlus0(){
            take();
            return this;
        }
    }

    /**
     * 无比的慢，我不想优化了，以及这里取巧了
     * @param candidates 非空且所有元素必须是正整数
     * @param target 无要求
     * @return 可以从candidates中取出若干数的具体方案
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || Arrays.stream(candidates).sum() < target)
            return new ArrayList<>();
        Set<List<Integer>> ret = new HashSet<>();
        List<Node> quene = new ArrayList<>();
        Arrays.sort(candidates);
        quene.add(new Node(candidates, 0, target, new ArrayList<>()));
        while (!quene.isEmpty()){
            Node current = quene.remove(0);
            if (current.target == 0)
                ret.add(current.ans);
            if (current.target <= 0)
                continue;
            if (current.index < candidates.length - 1)
                quene.add(current.getNextPlus1());
            quene.add(current.getNextPlus0());
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;
        Solution40 s = new Solution40();
        System.out.println(s.combinationSum2(candidates, target));
    }
}
