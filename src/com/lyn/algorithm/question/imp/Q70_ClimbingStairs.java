package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Q70_ClimbingStairs implements IQuestion {

    @Override
    public String title() {
        return "爬楼梯";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/climbing-stairs/";
    }

    @Override
    public void execute() {
        System.out.println(String.valueOf(climbStairs(10)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.2 MB, 在所有 Java 提交中击败了74.18%的用户
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int n_2 = 0;
        int n_1 = 1;
        int ret = 2;
        for (int i = 2; i < n; i++) {
            n_2 = n_1;
            n_1 = ret;
            ret = n_1 + n_2;
        }
        return ret;
    }

    /**
     * 超出时间限制  =-=
     */
    public long climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
}
