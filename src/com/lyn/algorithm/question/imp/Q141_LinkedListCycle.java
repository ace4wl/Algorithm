package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.bean.ListNode;
import com.lyn.algorithm.question.IQuestion;

public class Q141_LinkedListCycle implements IQuestion {
    @Override
    public String title() {
        return "链表有环";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/linked-list-cycle/";
    }

    @Override
    public void execute() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        node4.setNext(node1);

        System.out.println(hasCycle(node1));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了82.39%的用户
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (true) {
            if (p1 == null || p2 == null || p2.next == null) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }
        }
    }
}
