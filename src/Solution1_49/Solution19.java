package Solution1_49;

public class Solution19 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = head;
        ListNode faster = head;
        for (;n > 0; n--) {
            faster = faster.next;
        }
        if (faster == null){
            return head.next;
        }
        while (faster.next!=null){
            head = head.next;
            faster = faster.next;
        }
        head.next = head.next.next;
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 1; i < 1; i++) {
            tmp.next = new ListNode(i+1);
            tmp = tmp.next;
        }
        Solution19 s = new Solution19();
        head = s.removeNthFromEnd(head,1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}




