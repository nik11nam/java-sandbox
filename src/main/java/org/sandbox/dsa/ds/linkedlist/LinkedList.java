package org.sandbox.dsa.ds.linkedlist;

/**
 * Linked list custom implementation
 */
public class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(LinkedList list, int d) {

        Node newNode = new Node(d);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void delete(LinkedList list, int key) {

        Node currentNode = list.head;
        Node prev = null;

        // if key to be removed is at the head
        if (currentNode != null && currentNode.data == key) {
            list.head = currentNode.next;
            System.out.println(key + " found and deleted");
            return;
        }

        // if key to be removed is in the middle or tail
        while(currentNode != null && currentNode.data != key) {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            prev.next = currentNode.next;
            System.out.println(key + " found and deleted");
        } else {
            // if key not found in the list
            System.out.println(key + " not found");
        }
    }

    public void print(LinkedList list) {
        Node currentNode = list.head;

        System.out.print("LinkedList: ");
        while (currentNode.next != null) {
            System.out.print(currentNode.data + " ");

            currentNode = currentNode.next;
        }
        System.out.println(currentNode.data);
        System.out.println("==============");
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(list, 10);
        list.insert(list, 2);
        list.insert(list, 7);
        list.insert(list, 4);
        list.insert(list, 9);

        list.print(list);

        // Delete middle element
        list.delete(list,7);

        list.print(list);

        // Delete head
        list.delete(list,10);

        list.print(list);

    }
}
