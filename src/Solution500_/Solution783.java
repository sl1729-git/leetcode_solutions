package Solution500_;

import Utils.TreeNode;

public class Solution783 {
    private int solution(TreeNode root, int left, int right){
        if (root == null)
            return Integer.MAX_VALUE;

        int ret = Math.min(root.val - left, right - root.val);
        int subLeftRet = solution(root.left, left, root.val);
        int subRightRet = solution(root.right, root.val, right);

        return Math.min(ret, Math.min(subLeftRet, subRightRet));
    }

    /**todo 这里的解法对于任意的value范围需要进行修正，具体而言
     *  就是修改上面的solution方法，偏移0x8000_0000，改int为uint
     */
    public int minDiffInBST(TreeNode root) {
        assert root != null;
        assert !((root.left == null) && (root.right == null));



        return solution(root, -100000, 100000);
    }
}
