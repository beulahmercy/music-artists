package com.music.app.util;

import java.util.Arrays;

class ListNode {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    private int value;
    ListNode next;
    public ListNode (int value) {
        this.value = value;
        this.next = null;
    }

    static ListNode constructLinkedList() {

        ListNode head = null;
        ListNode tail = null;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        }
        return head;
    }

    static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }

    static ListNode deleteMiddleListNode(ListNode head) {
        ListNode temp = head;
        int mid = 5 / 2;
        while(mid-- > 1){
            head = head.next;
        }
        head.next = head.next.next;

        return temp;
    }
}
public class LinkedListCustom {
    public static void main(String[] args) {
        ListNode head = ListNode.constructLinkedList();
        ListNode node = head;
        for (int i = 1; i <= 5; i++) {
            System.out.println("args = " + node.getValue());
            node = node.getNext();

        }
        node = ListNode.reverseList(head);
        for (int i = 1; i <= 5; i++) {
            System.out.println("args = " + node.getValue());
            node = node.getNext();

        }
        head = ListNode.constructLinkedList();
        node = ListNode.deleteMiddleListNode(head);
        for (int i = 1; i <= 5; i++) {
            System.out.println("args = " + node.getValue());
            node = node.getNext();

        }
    }
}
