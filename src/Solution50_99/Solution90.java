package Solution50_99;

import java.util.*;

public class Solution90 {
    private List<Integer> long2List(Map<Integer, Integer> numsMap, long num){
        List<Integer> ret = new ArrayList<>();
        for (Integer key:numsMap.keySet()) {
            int current = numsMap.get(key);
            int count = (int) ((num >> (current * 4)) & 0xf);
            for (int i = 0; i < count; i++) {
                ret.add(key);
            }
        }

        return ret;
    }

    public List<List<Integer>> solutionBad(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            Integer current = nums[i];
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> list: ret){
                List<Integer> tmp2 = new ArrayList<>(list);
                list.add(current);
                tmp.add(tmp2);
            }
            ret.addAll(tmp);
        }

        return new ArrayList<>(ret);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.putIfAbsent(nums[i],i);
        }

        Set<Long> ans = new HashSet<>();
        ans.add((long)0);

        for (int i = 0; i < nums.length; i++) {
            int current = numMap.get(nums[i]);
            List<Long> tmp = new ArrayList<>();
            for (Long tmp2:ans) {
                long addOne = (((((tmp2 >> (current * 4)) & 0xf) + 1) << (current * 4) | (tmp2 & (~((long)0xf << (current * 4))))));
                tmp.add(addOne);
            }
            ans.addAll(tmp);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (Long tmp:ans) {
            ret.add(long2List(numMap, tmp));
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
        Solution90 s = new Solution90();
        System.out.println(s.subsetsWithDup(nums).size());
    }
}
