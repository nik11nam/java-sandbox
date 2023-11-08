package org.sandbox.dsa.ds.linkedlist;

public class ReverseLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        ListNode printNode = head;
        while(printNode != null) {
            System.out.println(printNode.data);
            printNode = printNode.next;
        }

        ListNode reversed = reverse(head);
        printNode = reversed;

        System.out.println("===== Reversed =====");
        while(printNode != null) {
            System.out.println(printNode.data);
            printNode = printNode.next;
        }
    }

}
