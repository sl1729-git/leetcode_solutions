package Solution151_300;

import Utils.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null){
            if (p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }

        return newHead.next;
    }
}
