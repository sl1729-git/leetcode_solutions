package Solution50_99;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution99 {
    private void solution(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, x = null, y = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val > root.val){
                y = root;
                if (x == null)
                    x = prev;
                else
                    break;
            }
            prev = root;
            root = root.right;
        }
        x.val ^= y.val;
        y.val ^= x.val;
        x.val ^= y.val;
    }

    public void recoverTree(TreeNode root) {
        solution(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        Solution99 s = new Solution99();
        s.recoverTree(root);
    }
}
