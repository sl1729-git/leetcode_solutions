package Solution100_150;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> currentLayer = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        currentLayer.add(root.val);
        ret.add(currentLayer);
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        List<TreeNode> nextLayer = new ArrayList<>(), tmp2;
        boolean flag = true;
        TreeNode tmp;
        while (currentLayer.size() > 0){
            flag = !flag;
            nextLayer.clear();
            for (int i = current.size()-1;i >= 0; i--) {
                tmp = current.get(i);
                if (flag){
                    if (tmp.left != null)
                        nextLayer.add(tmp.left);
                    if (tmp.right != null)
                        nextLayer.add(tmp.right);
                }else {
                    if (tmp.right != null)
                        nextLayer.add(tmp.right);
                    if (tmp.left != null)
                        nextLayer.add(tmp.left);
                }
            }
            currentLayer = new ArrayList<>();
            for (int i = 0; i < nextLayer.size(); i++) {
                currentLayer.add(nextLayer.get(i).val);
            }
            if (currentLayer.size() > 0)
                ret.add(currentLayer);
            tmp2 = current;
            current = nextLayer;
            nextLayer = tmp2;
        }
        return ret;
    }
}
