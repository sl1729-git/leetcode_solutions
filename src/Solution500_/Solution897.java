package Solution500_;

import Utils.TreeNode;

public class Solution897 {
    private TreeNode solution(TreeNode root, TreeNode pre){
        if (root == null)
            return pre;
        pre = solution(root.left, pre);
        pre.right = root;
        root.left = null;
        pre = solution(root.right, root);
        return pre;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode();
        solution(root, head);
        return head.right;
    }
}
