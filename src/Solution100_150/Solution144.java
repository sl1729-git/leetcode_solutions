package Solution100_150;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {

    private void solution1(TreeNode root, List<Integer> ret){
        if (root == null)
            return;
        ret.add(root.val);
        solution1(root.left, ret);
        solution1(root.right, ret);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        solution1(root, ret);
        return ret;
    }
}
