package com.matthewdiana.ctci.chapter2;

import java.util.HashSet;
import java.util.Set;

public class Question2_1 {

    public static void main(String[] args) {
        Node head = createLinkedList(5, 3, 6, 4, 3, 2, 5, 7);
        printLinkedList(head);
        removeDups(head);
        printLinkedList(head);
    }

    public static Node removeDups(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;

        Set<Integer> seen = new HashSet<>();

        Node curr = head.next;
        Node prev = head;

        seen.add(prev.data);

        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                seen.add(curr.data);
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }


    public static Node createLinkedList(Integer... vals) {
        Node head = new Node();
        Node curr = head;
        for (Integer val : vals) {
            curr.next = new Node();
            curr.next.data = val;
            curr = curr.next;
        }

        return head.next;
    }

    public static void printLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }


}

class Node {
    com.matthewdiana.ctci.chapter2.Node next;
    int data;
}