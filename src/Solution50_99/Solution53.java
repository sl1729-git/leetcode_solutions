package Solution50_99;

public class Solution53 {

    private class Node{
        int left, right;
        int maxSubValue;
        int maxSubLeftValue;
        int maxSubRightValue;

        public Node(int left, int right, int maxSubValue, int maxSubLeftValue, int maxSubRightValue) {
            this.left = left;
            this.right = right;
            this.maxSubValue = maxSubValue;
            this.maxSubLeftValue = maxSubLeftValue;
            this.maxSubRightValue = maxSubRightValue;
        }

        public Node() {

        }

        public Node merge(Node left, Node right){
            assert left != null && right != null && left.right == right.left;
            Node ret = new Node();
            ret.left = left.left;
            ret.right = right.right;
            if (Math.min(left.maxSubValue, right.maxSubValue) +
                    (left.maxSubRightValue+right.maxSubLeftValue) >= 0){
                ret.maxSubLeftValue = left.maxSubLeftValue;
                ret.maxSubRightValue = right.maxSubRightValue;
                ret.maxSubValue = left.maxSubValue + right.maxSubValue +
                        left.maxSubRightValue + right.maxSubLeftValue;
            }else if (left.maxSubValue > right.maxSubValue){
                ret.maxSubValue = left.maxSubValue;
                ret.maxSubLeftValue = left.maxSubLeftValue;
                ret.maxSubRightValue = left.maxSubRightValue + right.maxSubLeftValue +
                        right.maxSubValue + right.maxSubRightValue;
            }else {
                ret.maxSubValue = right.maxSubValue;
                ret.maxSubLeftValue = left.maxSubLeftValue + left.maxSubValue +
                        left.maxSubRightValue + right.maxSubLeftValue;
                ret.maxSubRightValue = right.maxSubRightValue;
            }
            return ret;
        }
    }


    public int maxSubArray(int[] nums) {
        int ret = 0;
        Node[] tree = new Node[nums.length];
        Node func = new Node();
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node(i,i,nums[i],0,0);
        }
        int len = tree.length/2, preLen = tree.length;
        while (len > 0){
            for (int i = 0; i < len; i++) {
                tree[i] = func.merge(tree[2*i],tree[2*i+1]);
            }
            tree[len] = ((preLen&1) == 1) ? tree[preLen-1] : tree[len];
            len += ((preLen&1) == 1) ? 1 : 0;
            preLen = len;
            len = preLen/2;
        }
        return tree[0].maxSubValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,-19,5,-4,20};
        Solution53 s = new Solution53();
        System.out.println(s.maxSubArray(nums));
    }
}
