package com.lyn.algorithm.bean;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode point = this;

        StringBuilder builder = new StringBuilder();
        builder.append(point.val);

        while (point.next != null) {
            point = point.next;
            builder.append(",");
            builder.append(point.val);
        }

        return builder.toString();
    }
}
