package Solution500_;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution872 {
    private void getLeft(TreeNode root, List<Integer> ret){
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            ret.add(root.val);

        getLeft(root.left, ret);
        getLeft(root.right, ret);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>(), tree2 = new ArrayList<>();
        getLeft(root1, tree1);
        getLeft(root2, tree2);

        return tree1.equals(tree2);
    }
}
