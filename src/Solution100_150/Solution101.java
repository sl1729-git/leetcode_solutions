package Solution100_150;

import Utils.TreeNode;

public class Solution101 {
    private boolean subMetricTest(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left != null && right != null && left.val == right.val)
            return subMetricTest(left.left, right.right) && subMetricTest(left.right, right.left);

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return subMetricTest(root.left, root.right);
    }
}
