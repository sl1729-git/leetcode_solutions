package Solution301_499;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    private void buildSumPath(TreeNode root, int currentSum){
        if (root == null)
            return;
        root.val += currentSum;
        buildSumPath(root.left, root.val);
        buildSumPath(root.right, root.val);
    }

    private int solution(TreeNode root, Map<Integer, Integer> pathSumCount, int target){
        if (root == null)
            return 0;
        int ret = pathSumCount.getOrDefault(root.val - target, 0);
        pathSumCount.put(root.val, pathSumCount.getOrDefault(root.val, 0) + 1);
        ret += solution(root.left, pathSumCount, target);
        ret += solution(root.right, pathSumCount, target);
        pathSumCount.put(root.val, pathSumCount.get(root.val) - 1);
        return ret;
    }

    public int pathSum(TreeNode root, int targetSum) {
        buildSumPath(root, 0);
        Map<Integer, Integer> pathSumCount = new HashMap<>();
        pathSumCount.put(0, 1);
        return solution(root, pathSumCount, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2))
                        ,new TreeNode(2,null,new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
//        TreeNode root = new TreeNode(5,
//                new TreeNode(4,
//                        new TreeNode(11), null),
//                new TreeNode(8,
//                        new TreeNode(13),
//                        new TreeNode(4)));
        Solution437 s = new Solution437();
        System.out.println(s.pathSum(root, 8));
    }
}
