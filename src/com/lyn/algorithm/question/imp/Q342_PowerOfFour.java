package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 */
public class Q342_PowerOfFour implements IQuestion {

    @Override
    public String title() {
        return "4的幂";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/power-of-four/";
    }

    @Override
    public void execute() {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(17));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了31.71%的用户
     */
    private boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        return isPower(n);
    }

    private boolean isPower(int n) {
        if (n == 4) return true;
        if (n < 4) return false;
        if (n % 4 != 0) return false;
        return isPower(n / 4);
    }
}
