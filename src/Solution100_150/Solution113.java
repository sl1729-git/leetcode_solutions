package Solution100_150;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution113 {
    private void solution(TreeNode root, int targetSum, Stack<TreeNode> preNode, List<List<Integer>> ret){
        if (root == null)
            return;

        int nextTarget = targetSum - root.val;
        preNode.push(root);
        if (nextTarget == 0 && root.left == null && root.right == null){
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode node:preNode) {
                tmp.add(node.val);
            }
            ret.add(tmp);
        }

        solution(root.left, nextTarget, preNode, ret);
        solution(root.right, nextTarget, preNode, ret);
        preNode.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        solution(root, targetSum, stack, ret);
        return ret;
    }
}
