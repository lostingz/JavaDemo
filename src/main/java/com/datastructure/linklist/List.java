/**
 * Chsi
 * Created on 2015年12月16日
 */
package com.datastructure.linklist;

public class List {
    private Node head;

    public void init() {
        Node node = new Node();
        this.head = node;
    }

    // 头插
    public void add(Node node) {
        node.next = head.next;
        head.next = node;
    }

    // 尾插
    public void addTail(Node node) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.next = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void reverse(List list) {
        Node q = list.head.next;
        Node p = list.head;
        while (q.next != null) {
            list.head = q.next;
            q.next = p;
            p = q;
            q = list.head;
        }
        list.head.next = p;
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        List list = new List();
        list.init();
        for (int i = 0; i < 100; i++) {
            Node node = new Node("a" + i);
            // list.add(node);
            list.addTail(node);
        }
        Node head = list.head;
        List.reverse(list);
    }
}