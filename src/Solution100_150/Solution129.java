package Solution100_150;

import Utils.TreeNode;

public class Solution129 {


    private void solution(TreeNode root, int sum, int[] ret){
        assert ret.length == 1;
        if (root == null)
            return;
        sum *= 10;
        sum += root.val;
        solution(root.left, sum, ret);
        solution(root.right, sum, ret);
        if (root.left == null && root.right == null)
            ret[0] += sum;
    }

    public int sumNumbers(TreeNode root) {
        int[] ret = new int[]{0};
        solution(root, 0, ret);
        return ret[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);
        Solution129 s = new Solution129();
        System.out.println(s.sumNumbers(root));
    }
}
