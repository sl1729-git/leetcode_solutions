package Solution100_150;

public class Solution147 {

    private ListNode insert(ListNode head, ListNode node){
        while (head.next != null){
            if (node.val < head.next.val){
                break;
            }
            head = head.next;
        }
        ListNode ret = node.next;
        node.next = head.next;
        head.next = node;
        return ret;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = head.next, ret = head;
        head.next = null;
        head = new ListNode(Integer.MIN_VALUE, head);
        while (tmp != null){
            tmp = insert(head, tmp);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
//        Solution100_150.ListNode tmp = node;
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        Solution147 s = new Solution147();
        s.insertionSortList(node);
    }
}
