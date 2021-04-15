package Solution151_300;

import Utils.TreeNode;

import java.util.Stack;

public class Solution173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15, new TreeNode(9), new TreeNode(20));
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
    }
}

class BSTIterator {
    private TreeNode nextNode = null;
    private TreeNode root = null;
    private Stack<TreeNode> stack = new Stack<>();


    private void putNext(){
        nextNode = null;
        if (stack.isEmpty())
            return;
        root = stack.pop();
        nextNode = root;

        root = root.right;
        if (root == null)
            return;

        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        while (root != null && root.left != null){
            stack.push(root);
            root = root.left;
        }
        stack.push(root);
        putNext();
    }

    public int next() {
        int ret = nextNode.val;
        putNext();
        return ret;
    }

    public boolean hasNext() {
        return nextNode != null;
    }
}