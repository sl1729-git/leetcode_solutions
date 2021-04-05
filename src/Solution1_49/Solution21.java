package Solution1_49;

public class Solution21 {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode tmp = ret;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 == null)
            tmp.next = l2;
        if (l2 == null)
            tmp.next = l1;
        return ret.next;

    }
}
