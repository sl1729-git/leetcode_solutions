package Solution151_300;

public class Solution234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode reverse(ListNode head){
        ListNode pointer1 = head, pointer2 = head.next, tmp;
        while (pointer2 != null){
            tmp = pointer2.next;
            pointer2.next = pointer1;
            pointer1 = pointer2;
            pointer2 = tmp;
        }
        head.next = null;
        return pointer1;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode pointer1 = head, pointer2 = head, mid;
        while (pointer2 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if (pointer2 == null)
                break;
            pointer2 = pointer2.next;
        }
        pointer1 = reverse(pointer1);
        pointer2 = head;
        while (pointer1 != null){
            if (pointer1.val != pointer2.val)
                return false;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return true;
    }
}
