package Solution50_99;

import Utils.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        head = new ListNode(0, head);
        ListNode[] stack = new ListNode[right - left + 1];

        ListNode tmp = head;
        left --;
        for (int i = 0; i < left; i++) {
            tmp = tmp.next;
        }
        ListNode tmp2 = tmp;
        tmp = tmp.next;

        for (int i = 0; i < stack.length; i++) {
            stack[i] = tmp;
            tmp = tmp.next;
        }

        for (int i = stack.length - 1; i >= 0; i--) {
            tmp2.next = stack[i];
            tmp2 = tmp2.next;
        }

        tmp2.next = tmp;

        return head.next;
    }
}
