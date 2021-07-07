package Offer;

import Utils.TreeNode;

import java.util.Stack;

public class Solution37 {
    public static void main(String[] args) {
        Codec test = new Codec();
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(test.serialize(root));
        TreeNode other = test.deserialize(test.serialize(root));
        System.out.println(test.serialize(other));
    }
}

/**
 * 序列化的方式是（val(serialize(left)serialize(right)）
 * 逆序列化就是解码
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        ret.append('(');
        ret.append(root == null ? "null" : root.val);
        if (root == null) {
            ret.append(')');
            return ret.toString();
        }
        ret.append(serialize(root.left));
        ret.append(serialize(root.right));
        ret.append(')');
        return ret.toString();
    }

    private void getNum(char[] buf, int[]index){
        int currentIndex = index[0];
        if (buf[currentIndex] == '+' || buf[currentIndex] == '-')
            currentIndex ++;
        while (currentIndex < buf.length && buf[currentIndex] >= '0' && buf[currentIndex] <= '9')
            currentIndex ++;
        index[0] = currentIndex;
    }

    private TreeNode doDeserialize(char[] buf, int[] index){
        int currentIndex = index[0];
        if (currentIndex >= buf.length)
            return null;
        if (buf[currentIndex] == '(')
            currentIndex ++;
        if (buf[currentIndex] == 'n'){
            index[0] = currentIndex + 5;
            return null;
        }
        int numLeft = currentIndex;
        index[0] = currentIndex;
        getNum(buf, index);
        TreeNode ret = new TreeNode();
        ret.val = Integer.valueOf(new String(buf, numLeft, index[0] - numLeft));
        ret.left = doDeserialize(buf, index);
        ret.right = doDeserialize(buf, index);
        if (buf[index[0]] == ')')
            index[0] ++;
        return ret;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return doDeserialize(data.toCharArray(), new int[]{0});
    }
}