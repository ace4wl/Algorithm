package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * <p>
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 */
public class Q1672_RichestCustomerWealth implements IQuestion {

    @Override
    public String title() {
        return "最富有客户的资产总量";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/richest-customer-wealth/";
    }

    @Override
    public void execute() {
        System.out.println(maximumWealth(new int[][]{
                {1, 2, 3}, {3, 2, 1}
        }));

        System.out.println(maximumWealth(new int[][]{
                {1, 5}, {7, 3}, {3, 5}
        }));

        System.out.println(maximumWealth(new int[][]{
                {2, 8, 7}, {7, 1, 3}, {1, 9, 5}
        }));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了75.23%的用户
     */
    private int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(max, sum(account));
        }
        return max;
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
