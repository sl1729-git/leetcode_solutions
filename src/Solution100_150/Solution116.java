package Solution100_150;

public class Solution116 {

    public void build(Node root, Node next){
        if (root == null)
            return;
        root.next = next;
        build(root.right, next == null ? null : next.left);
        build(root.left, root.right);
    }


    public Node connect(Node root) {
        build(root, null);
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
