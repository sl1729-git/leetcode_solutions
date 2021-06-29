package Solution1_49;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution39 {

    private Set<List<Integer>> putNum(Set<List<Integer>> set, int num){
        if (set == null)
            return set;
        for (List<Integer> list: set) {
            list.add(num);
        }
        return set;
    }

    private Set<List<Integer>> solution(int[] candidates, int target, int len){
        assert len > 1;
        Set<List<Integer>> ret = new HashSet<>();
        Set<List<Integer>> tmp;
        int tmp1 = candidates[0], tmp2 = candidates[1];
        int tmpMin = Math.min(tmp1, tmp2), tmpMax = Math.max(tmp1, tmp2);
        if (len > 2){
            tmp = putNum(solution(candidates, target-candidates[candidates.length-1], len)
                    , candidates[candidates.length-1]);
            if (tmp != null)
                ret.addAll(tmp);
            tmp = solution(candidates, target, len-1);
            if (tmp != null)
                ret.addAll(tmp);
        }else {
            if (target < tmpMin)
                return null;
            if ((target % tmpMin != 0 && target % tmpMax != 0) || target % tmpMax != tmpMin)
                return null;
            if (tmpMax % tmpMin != 0){
                List<Integer> solve = new ArrayList<>();

            }

        }
        return null;
    }

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
            this.target -= candidates[this.index];
            this.ans.add(candidates[index]);
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
     *
     * @param candidates 非空且所有元素必须是正整数
     * @param target 无要求
     * @return 可以从candidates中取出若干数的具体方案
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null)
            return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        List<Node> quene = new ArrayList<>();
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
        return ret;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Solution39 s = new Solution39();
        System.out.println(s.combinationSum(candidates, target));
    }
}
