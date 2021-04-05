package Solution100_150;

import Utils.Node;

public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node pointer = head, tmp1;
        while (pointer != null){
            tmp1 = new Node(pointer.val);
            tmp1.next = pointer.next;
            pointer.next = tmp1;
            pointer = tmp1.next;
        }

        pointer = head;
        while (pointer != null){
            tmp1 = pointer.next;
            tmp1.random = pointer.random == null ? null : pointer.random.next;
            pointer = tmp1.next;
        }

        Node ret = head.next, tmp2;
        pointer = head;
        while (pointer != null){
            tmp1 = pointer.next;
            tmp2 = tmp1.next;
            pointer.next = tmp2;
            if (tmp2 != null)
                tmp1.next = tmp2.next;
            pointer = tmp2;
        }

        return ret;
    }
//[[7,null],[13,0],[11,4],[10,2],[1,0]]
    public static void main(String[] args) {
        Node head = new Node(7);
        Node tmp1 = new Node(13);
        Node tmp2 = new Node(11);
        Node tmp3 = new Node(10);
        Node tmp4 = new Node(1);

        head.next = tmp1;
        tmp1.next = tmp2;
        tmp2.next = tmp3;
        tmp3.next = tmp4;

        tmp1.random = head;
        tmp2.random = tmp4;
        tmp3.random = tmp2;
        tmp4.random = head;

        Solution138 s = new Solution138();
        s.copyRandomList(head);
    }
}
