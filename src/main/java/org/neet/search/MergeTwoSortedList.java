package org.neet.search;

public class MergeTwoSortedList {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        // To return the pointer to the root node of the linked list
        ListNode curr = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // If the lists are not of same size, pending sublist merge to the final list
        curr.next = (l1 != null) ? l1 : l2;

        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);

        ListNode printNode = mergeList(l1, l2);
        while(printNode != null) {
            System.out.println(printNode.val);
            printNode = printNode.next;
        }
    }
}
