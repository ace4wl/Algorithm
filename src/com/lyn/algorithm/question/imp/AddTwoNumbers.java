package com.lyn.algorithm.question.imp;


import com.lyn.algorithm.bean.ListNode;
import com.lyn.algorithm.question.IQuestion;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers implements IQuestion {

    @Override
    public String title() {
        return "两数相加";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/add-two-numbers/";
    }

    @Override
    public void execute() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(4, null))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode ret = addTwoNumbers(l1, l2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(ret);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode pre = null;

        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;

            ListNode newNode = new ListNode();
            int add = value1 + value2 + carry;

            newNode.val = add % 10;
            carry = add / 10;

            if (start == null) start = newNode;
            if (pre != null) pre.next = newNode;

            pre = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return start;
    }
}
