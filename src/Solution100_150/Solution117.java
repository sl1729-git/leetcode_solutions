package Solution100_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution117 {
    // 可以考虑使用上一层构建的链表去完成，这样可以减少空间复杂度
    public Node connect(Node root) {
        if (root == null)
            return root;

        List<Node> queue = new ArrayList<>();
        List<Node> queue2 = new ArrayList<>();
        List<Node> tmp;

        queue.add(root);
        while (!queue.isEmpty()){
            Node next = null;
            for (int i = queue.size() - 1; i >= 0; i--) {
                Node current = queue.get(i);
                queue.get(i).next = next;
                if (current.right != null)
                    queue2.add(0, current.right);
                if (current.left != null)
                    queue2.add(0, current.left);
                next = current;
            }

            queue.clear();
            tmp = queue;
            queue = queue2;
            queue2 = tmp;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2,new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);

        Solution117 s = new Solution117();
        s.connect(root);
    }
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
};