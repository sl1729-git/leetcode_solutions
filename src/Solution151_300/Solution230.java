package Solution151_300;

import Utils.TreeNode;

import java.util.Stack;

public class Solution230 {
    private void solution(TreeNode root, int[] k, int[] ans){
        if (root == null)
            return;
        solution(root.left, k, ans);
        k[0]--;
        if (k[0] == 0) {
            ans[0] = root.val;
            return;
        }
        solution(root.right, k, ans);
    }

    /**
     * 我懒了，就凑活用递归吧
     * @param root 二叉树的根节点
     * @param k 要找的第k小元素
     * @return 如果没有，返回0，如果有，返回第k小的值
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1], ans = new int[1];
        count[0] = k;
        solution(root, count, ans);
        return ans[0];
    }
}
