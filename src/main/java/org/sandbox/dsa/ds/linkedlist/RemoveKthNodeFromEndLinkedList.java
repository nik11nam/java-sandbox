package org.sandbox.dsa.ds.linkedlist;

public class RemoveKthNodeFromEndLinkedList {

    private static ListNode removeKthNodeFromEndLinkedList(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode first = head;
        ListNode second = head;

        for (int i=0; i<k; i++){
            first = first.next;
        }

        if (first == null) {
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }

        while(first.next != null) {
            first = first.next;
            second = second.next;
        }

        ListNode temp = second.next;
        second.next = temp.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode printNode = removeKthNodeFromEndLinkedList(head, 3);
        while(printNode != null) {
            System.out.println(printNode.data);
            printNode = printNode.next;
        }
    }
}
