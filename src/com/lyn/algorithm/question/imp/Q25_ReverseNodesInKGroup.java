package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.bean.ListNode;
import com.lyn.algorithm.question.IQuestion;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Q25_ReverseNodesInKGroup implements IQuestion {
    @Override
    public String title() {
        return "K 个一组翻转链表";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/reverse-nodes-in-k-group";
    }

    @Override
    public void execute() {
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7, null))));
        System.out.println(reverseKGroup(l1, 1));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了71.73%的用户
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        int bucket = 0;
        ListNode bucketHead = head;
        ListNode bucketPreEnd = null;


        ListNode newHead = null;

        while (head != null) {
            if (bucket < k - 1) {
                bucket++;
                head = head.next;
                continue;
            }

            //断线
            ListNode curNode = head.next;
            head.next = null;

            //分段翻转
            ListNode reverseList = reverseList(bucketHead);

            //bucketHead变成尾
            if (bucketPreEnd != null) {
                bucketPreEnd.next = reverseList;
            }
            bucketPreEnd = bucketHead;
            bucketHead.next = curNode;

            if (newHead == null) {
                newHead = reverseList;
            }

            bucket = 0;
            head = bucketHead.next;
            bucketHead = bucketHead.next;
        }

        return newHead;
    }

    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
