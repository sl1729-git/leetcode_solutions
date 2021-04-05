package Solution50_99;

import Utils.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode tmp2 = new ListNode(-1, head);
        ListNode ret = tmp2;

        int currentVal;
        boolean duplicate = false;

        while (tmp != null){
            currentVal = tmp.val;
            duplicate = false;
            while (tmp.next != null && tmp.next.val == currentVal){
                tmp = tmp.next;
                duplicate = true;
            }

            if (!duplicate){
                tmp2.next.val = currentVal;
                tmp2 = tmp2.next;
            }

            tmp = tmp.next;
        }


        tmp2.next = null;
        return ret.next;
    }
}
