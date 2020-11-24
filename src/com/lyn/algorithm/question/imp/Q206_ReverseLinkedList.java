package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.bean.ListNode;
import com.lyn.algorithm.question.IQuestion;

public class Q206_ReverseLinkedList implements IQuestion {

    @Override
    public String title() {
        return "翻转链表";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/reverse-linked-list/";
    }

    @Override
    public void execute() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(node1);
        System.out.println(reverseList(node1));
        System.out.println(node5);
    }

    // 1->2->3->4->5
    // |
    // v
    // 1->2<-3<-4<-5

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了44.46%的用户
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
