package Solution50_99;

import Utils.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1), other = new ListNode(-1);
        ListNode smallerPointer = smaller, otherPointer = other, headPointer = head;
        while (headPointer != null){
            if (headPointer.val < x){
                smallerPointer.next = headPointer;
                smallerPointer = smallerPointer.next;
            }else {
                otherPointer.next = headPointer;
                otherPointer = otherPointer.next;
            }
            headPointer = headPointer.next;
        }
        smallerPointer.next = other.next;
        otherPointer.next = null;
        return smaller.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,5,2};
        ListNode head = new ListNode(1);
        ListNode point = head;
        for (int i = 1; i < nums.length; i++) {
            point.next = new ListNode(nums[i]);
            point = point.next;
        }
        Solution86 s = new Solution86();
        s.partition(head, 3);
    }
}
