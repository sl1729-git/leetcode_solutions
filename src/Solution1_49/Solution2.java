package Solution1_49;


public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        assert l1 != null && l2 != null;
        ListNode ret = new ListNode(0);
        ListNode tmp = ret;
        boolean flag = false;
        int out = 0;
        while(l1 != null && l2 != null){
            tmp = tmp.next = new ListNode(0);
            out = l1.val + l2.val + (flag?1:0);
            tmp.val += out % 10;
            flag = out >= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = (l1 == null) ? l2 : l1;
        while (l1 != null){
            tmp = tmp.next = new ListNode(0);
            out = l1.val + (flag ? 1 : 0);
            flag = out >= 10;
            tmp.val += out % 10;
            l1 = l1.next;
        }
        if (l1 == null && flag){
            tmp.next = new ListNode(1);
        }
        return ret.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


