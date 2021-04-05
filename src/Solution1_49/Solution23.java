package Solution1_49;

import java.util.ArrayList;
import java.util.List;

public class Solution23 {
    private int[] lens;

    public void buildTree(int[] tree, int len){
        int indexMin = tree.length - len, indexMax = tree.length;
        int index = tree.length - len;
        while (indexMin+1 != indexMax){
            for (int i = indexMin; i < indexMax; i+=2) {
                if (i + 1 >= indexMax){
                    tree[indexMin-(indexMax-i+1)/2] = tree[i];
                }else {
                    tree[indexMin-(indexMax-i+1)/2] = tree[i] < tree[i+1] ? tree[i] : tree[i+1];
                }
            }
            indexMax = indexMin;
            len = (len&1) == 0 ? len/2 : len/2 + 1;
            indexMin -= len;
        }
    }

    public int popAndInert(int[] tree, ListNode[] lists){
        int ret = tree[0];
        int len = lists.length;
        int indexMin = tree.length - len, indexMax = tree.length;
        int index = 0, lensIndex = 0;

        while (index < indexMax){
            if (index >= indexMin){
                break;
            }
            if (tree[index] == tree[2*(index-lens[lensIndex])+lens[lensIndex+1]]){
                index = 2*(index-lens[lensIndex])+lens[lensIndex+1];
            }else if (2*(index-lens[lensIndex])+lens[lensIndex+1]+1 < lens[lensIndex+2]){
                if (tree[index] == tree[2*(index-lens[lensIndex])+lens[lensIndex+1]+1]){
                    index = 2*(index-lens[lensIndex])+lens[lensIndex+1]+1;
                }
            }else {
                throw new RuntimeException("tree error");
            }
            lensIndex ++;
        }

        if (lists[index-indexMin] == null || lists[index-indexMin].next == null){
            tree[index] = Integer.MAX_VALUE;
        }else {
            lists[index - indexMin] = lists[index - indexMin].next;
            tree[index] = lists[index - indexMin].val;
        }


        while (indexMin+1 != indexMax){
            index -= ((index-indexMin)&1) == 0 ? 0 : 1;
            if (index+1 < indexMax){
                if (tree[index] < tree[index+1]){
                    tree[indexMin-(indexMax-index+1)/2] = tree[index];
                }else {
                    tree[indexMin-(indexMax-index+1)/2] = tree[index+1];
                }
            }else {
                tree[indexMin-(indexMax-index+1)/2] = tree[index];
            }
            index = indexMin-(indexMax-index+1)/2;
            indexMax = indexMin;
            len = (len&1) == 0 ? len/2 : len/2 + 1;
            indexMin -= len;
        }
        return ret;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        int treeLen = 0, listLen = lists.length, lensLen = 0;
        while (listLen != 1){
            treeLen += listLen;
            listLen = (listLen&1) == 0 ? listLen/2 : listLen/2 + 1;
            lensLen ++;
        }
        int[] tree = new int[++treeLen];
        lensLen += 2;
        this.lens = new int[lensLen];
        this.lens[0] = 0;
        this.lens[1] = 1;
        listLen = lists.length;
        while (listLen != 1){
            this.lens[--lensLen] = listLen;
            listLen = (listLen&1) == 0 ? listLen/2 : listLen/2 + 1;
        }
        for (int i = 1; i < this.lens.length; i++) {
            this.lens[i] = this.lens[i] + this.lens[i-1];
        }
        for (int i = 0; i < lists.length; i++) {
            tree[i + treeLen - lists.length] = lists[i] == null ? Integer.MAX_VALUE : lists[i].val;
        }
        buildTree(tree,lists.length);
        ListNode ret = new ListNode();
        ListNode pointer = ret;
        List<Integer> retTmp = new ArrayList<>();
        int tmp = popAndInert(tree, lists);
        while (tmp != Integer.MAX_VALUE){
            retTmp.add(tmp);
            tmp = popAndInert(tree, lists);
        }
        for (int i = 0; i < retTmp.size(); i++) {
            pointer.next = new ListNode(retTmp.get(i));
            pointer = pointer.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        List<ListNode> test = new ArrayList<>();
        ListNode tmp1 = new ListNode();
        ListNode pointer = tmp1;
        pointer.val = 1;
        pointer.next = new ListNode(4);
        pointer = pointer.next;
        pointer.next = new ListNode(5);
        test.add(tmp1);
        ListNode tmp2 = new ListNode();
        pointer = tmp2;
        pointer.val = 1;
        pointer.next = new ListNode(3);
        pointer = pointer.next;
        pointer.next = new ListNode(4);
        test.add(tmp2);
        ListNode tmp3 = new ListNode();
        pointer = tmp3;
        pointer.val = 2;
        pointer.next = new ListNode(6);

//        pointer = pointer.next;
//        pointer.next = new Solution1_49.ListNode(5);
        test.add(tmp3);
//        for (int i = 0; i < 10; i++) {
//            test.add(null);
//        }

        Solution23 s = new Solution23();
        s.mergeKLists(test.toArray(new ListNode[0]));



    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}