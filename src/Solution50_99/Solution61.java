package Solution50_99;

import Utils.ListNode;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode ret = head;
        int len = 1;
        while (ret.next != null){
            len ++;
            ret = ret.next;
        }

        ret.next = head;

        int jumpLen = len - (k % len);
        ListNode tmp = ret;
        for (int i = 0; i < jumpLen; i++) {
            tmp = tmp.next;
        }

        ret = tmp.next;
        tmp.next = null;

        return ret;
    }
}
