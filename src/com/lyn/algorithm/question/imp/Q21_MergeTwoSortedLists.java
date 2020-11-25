package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.bean.ListNode;
import com.lyn.algorithm.question.IQuestion;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q21_MergeTwoSortedLists implements IQuestion {

    @Override
    public String title() {
        return "合并两个有序链表";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/merge-two-sorted-lists/";
    }

    @Override
    public void execute() {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7, null))));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(6, null)));
        System.out.println(mergeTwoLists(l1, l2));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了74.97%的用户
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
