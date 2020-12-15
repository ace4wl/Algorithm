package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Q7_ReverseInteger implements IQuestion {

    @Override
    public String title() {
        return "整数反转";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/reverse-integer/";
    }

    @Override
    public void execute() {
        System.out.println(reverse(123));
        System.out.println(reverse(-1235));
        System.out.println(reverse(120));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了33.60%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了85.77%的用户
     */
    public int reverse(int x) {
        int length = String.valueOf(Math.abs(x)).length();
        long ret = 0;
        int i = 0;

        while (x != 0) {
            int num = x % 10;
            ret += (num * Math.pow(10, length - i++ - 1));
            x = x / 10;
        }

        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 0 : (int) ret;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了33.60%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了52.72%的用户
     */
    public int reverse1(int x) {
        int[] arr = new int[String.valueOf(Math.abs(x)).length()];
        int p = 0;

        while (x != 0) {
            arr[p++] = x % 10;
            x = x / 10;
        }

        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += (arr[i] * Math.pow(10, arr.length - i - 1));
        }

        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 0 : (int) ret;
    }

}
