package com.matthewdiana.ctci.chapter2;

public class Question2_2 {

    public static void main(String[] args) {

        Node n = createLinkedList(4, 5, 3, 2, 1, 7, 3);
        System.out.println(kthToList(n, 3).data);

    }

    public static Node kthToList(Node head, int k) {
        if (head == null || k < 1) return null;

        Node fast = head, slow = head;

        for (int i = 0; i < k; i++) {
            if (fast.next == null) return null;
            else fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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
