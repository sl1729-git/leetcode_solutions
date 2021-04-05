package Solution50_99;

import Utils.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head, pointer1 = head, pointer2 = head;
        while (pointer1 != null){
            while (pointer2 != null && pointer1.val == pointer2.val)
                pointer2 = pointer2.next;
            pointer1.next = pointer2;
            pointer1 = pointer2;
        }

        return ret;
    }
}
