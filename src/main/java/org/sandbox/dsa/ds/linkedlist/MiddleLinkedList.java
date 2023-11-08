package org.sandbox.dsa.ds.linkedlist;

public class MiddleLinkedList {

    private static ListNode findMiddleNode(ListNode head) {
        if (head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null && fast.next == null)
            System.out.println(slow.data);
        else
            System.out.println(slow.data + "," + slow.next.data);

        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode middleNode = findMiddleNode(head);
        System.out.println(middleNode.data);
    }
}
