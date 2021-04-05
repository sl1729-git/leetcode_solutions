package Solution100_150;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;

        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        Queue<TreeNode> tmp;

        queue1.add(root);
        while (!queue1.isEmpty()){
            List<Integer> tmp2 = new ArrayList<>();
            for (TreeNode node:queue1) {
                if (node.left != null)
                    queue2.add(node.left);
                if (node.right != null)
                    queue2.add(node.right);
                tmp2.add(node.val);
            }
            ret.add(tmp2);
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            queue2.clear();
        }

        return ret;
    }
}
