package Solution1_49;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ret = new ListNode(0,head);
        ListNode pointer1, pointer2, tmp;
        pointer1 = ret;
        pointer2 = ret.next.next;
        while (pointer2 != null){
            tmp = pointer2.next;
            pointer1.next.next = pointer2.next;
            pointer2.next = pointer1.next;
            pointer1.next = pointer2;
            pointer2 = tmp;
            if (pointer2 == null){
                break;
            }
            pointer2 = pointer2.next;
            pointer1 = pointer1.next.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Solution24 s = new Solution24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new Solution1_49.ListNode(4);
        ListNode tmp = s.swapPairs(head);
        System.out.println(tmp.val);
    }
}