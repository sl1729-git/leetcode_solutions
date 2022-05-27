package Solution500_;

import Utils.TreeNode;

public class Solution938 {
    private int solution(TreeNode root, int low, int high){
        int ret = 0;
        if (root == null)
            return ret;
        if (root.val >= low && root.val <= high){
            ret += root.val;
        }
        ret += solution(root.left, low, high);
        ret += solution(root.right, low, high);
        return ret;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return solution(root, low, high);
    }
}
