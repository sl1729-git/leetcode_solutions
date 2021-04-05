import Utils.TreeNode;

public class Solution222 {

    private void count(TreeNode root, int[] ret){
        if (root == null)
            return;
        ret[0] ++;
        count(root.left, ret);
        count(root.right, ret);
    }

    public int countNodes(TreeNode root) {
        int[] ret = new int[]{0};
        count(root,ret);
        return ret[0];
    }
}
