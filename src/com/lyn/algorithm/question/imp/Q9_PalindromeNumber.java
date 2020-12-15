package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Q9_PalindromeNumber implements IQuestion {

    @Override
    public String title() {
        return "回文数";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/palindrome-number/";
    }

    @Override
    public void execute() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(110));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(101));
    }

    /**
     * 执行用时：9 ms,在所有 Java 提交中击败了99.41%的用户
     * 内存消耗：37.8 MB在所有 Java 提交中击败了80.34%的用户
     */
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
