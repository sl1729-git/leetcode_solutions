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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }
}
