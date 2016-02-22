/**
 * Chsi
 * Created on 2015年12月16日
 */
package com.datastructure.linklist;

public class Node {
    public String data;
    public Node next;

    public Node() {
    }
    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
