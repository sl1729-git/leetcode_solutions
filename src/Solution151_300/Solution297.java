package Solution151_300;

import Utils.TreeNode;

public class Solution297 {
}

/**
 * 具体见Offer.Solution37中的内容，此为copy
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