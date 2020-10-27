package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

public class Q5_LongestPalindrome implements IQuestion {

    @Override
    public String title() {
        return "最长回文子串";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/longest-palindromic-substring/";
    }

    @Override
    public void execute() {
        System.out.println(longestPalindrome("abba"));
    }

    /**
     * 执行用时：40 ms, 在所有 Java 提交中击败了70.02%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了68.16%的用户
     */
    public String longestPalindrome(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            String ret1 = isPalindrome(s, i, i);
            String ret2 = isPalindrome(s, i, i + 1);
            if (ret1.length() > ret2.length() && ret1.length() > ret.length()) {
                ret = ret1;
            } else if (ret2.length() > ret1.length() && ret2.length() > ret.length()) {
                ret = ret2;
            }
        }
        return ret;
    }

    private String isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
