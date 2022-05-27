package Solution500_;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>(), tmp;
        TreeNode x_node = null, y_node = null;
        stack1.push(root);
        boolean ret = false;
        while (!stack1.isEmpty()){
            for (TreeNode node:stack1) {
                if (node.left != null){
                    stack2.push(node.left);
                    if (node.left.val == x && x_node == null) x_node = node;
                    if (node.left.val == y && y_node == null) y_node = node;
                }

                if (node.right != null){
                    stack2.push(node.right);
                    if (node.right.val == x && x_node == null) x_node = node;
                    if (node.right.val == y && y_node == null) y_node = node;
                }
            }
            if (x_node != null && y_node != null)
                return x_node != y_node;
            if (x_node != null || y_node != null)
                return false;
            stack1.clear();
            tmp = stack1;
            stack1 = stack2;
            stack2 = tmp;
        }

        return false;
    }
}
