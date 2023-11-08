package org.sandbox.dsa.ds.linkedlist;

import java.util.List;

// Find nth node from end of the Linked list
public class FindKNodeFromEndLinkedList {

    private static ListNode getKNodeFromEnd(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode first = head;
        ListNode second = head;

        for (int i=0; i < k-1; i++) {
            first = first.next;
        }

        while(first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = getKNodeFromEnd(head, 3);
        System.out.println(node.data);
    }

}
