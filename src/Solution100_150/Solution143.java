package Solution100_150;

public class Solution143 {

    private ListNode reverse(ListNode head){
        ListNode ret = head, tmp;
        ListNode pointer1 = head, pointer2 = head.next;
        while (pointer2 != null){
            tmp = pointer2.next;
            pointer2.next = pointer1;
            ret = pointer2;
            pointer1 = pointer2;
            pointer2 = tmp;
        }
        head.next = null;
        return ret;
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid, tmp;
        ListNode pointerFast = head, pointerSlow = head;
        while (pointerFast.next != null){
            pointerFast = pointerFast.next;
            if (pointerFast.next != null)
                pointerFast = pointerFast.next;
            else
                break;
            pointerSlow = pointerSlow.next;
        }
        mid = pointerSlow.next;
        pointerFast = reverse(mid);
        pointerSlow = head;
        tmp = pointerSlow;
        while (pointerFast != null){
            tmp = pointerSlow.next;
            pointerSlow.next = pointerFast;
            pointerSlow = tmp;
            tmp = pointerFast.next;
            pointerFast.next = pointerSlow;
            pointerFast = tmp;

        }
        pointerSlow.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        for (int i = 1; i < 10; i++) {
            tmp.val = i;
            tmp.next = new ListNode(i+1);
            tmp = tmp.next;
        }
        Solution143 s = new Solution143();
        s.reorderList(head);
        System.out.println("123");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}