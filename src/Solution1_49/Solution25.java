package Solution1_49;

public class Solution25 {
    public void reverse(ListNode head, ListNode tail, int length){
        ListNode[] nodes = new ListNode[length];
        ListNode tailNext = tail.next;
        ListNode pointer = head.next;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = pointer;
            pointer = pointer.next;
        }
        pointer = head;
        for (int i = nodes.length-1; i >= 0; i--) {
            pointer.next = nodes[i];
            pointer = pointer.next;
        }
        pointer.next = tailNext;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode ret = new ListNode(0,head);
        ListNode pointer1 = ret, pointer2 = ret, pointer3;
        while (pointer2 != null){
            for (int i = 0; i < k; i++) {
                pointer2 = pointer2.next;
                if (pointer2 == null)
                    return ret.next;
            }
            pointer3 = pointer1.next;
            reverse(pointer1, pointer2, k);
            pointer1 = pointer2 = pointer3;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pointer = head;
        for (int i = 1; i < 5; i++) {
            pointer.next = new ListNode(i+1);
            pointer = pointer.next;
        }
        Solution25 s = new Solution25();
        pointer = s.reverseKGroup(head, 3);
        System.out.println(pointer.val);
    }
}
