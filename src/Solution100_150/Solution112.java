package Solution100_150;

import Utils.TreeNode;

public class Solution112 {

    private boolean solution(TreeNode root, TreeNode father, int targetSum){
        if (root == null)
            return (father.left == null && father.right == null) && targetSum == 0;
        int nextTarget = targetSum - root.val;
        return solution(root.left, root, nextTarget) || solution(root.right, root, nextTarget);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return solution(root, null, targetSum);
    }
}
