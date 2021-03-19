package com.lyn.algorithm.question.offer;

import com.lyn.algorithm.question.IQuestion;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class O53_QueShiDeShuZiLcof implements IQuestion {

    @Override
    public String title() {
        return "0～n-1中缺失的数字";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/";
    }

    @Override
    public void execute() {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
        System.out.println(missingNumber(new int[]{0, 2, 3}));
        System.out.println(missingNumber(new int[]{0, 1, 3, 4}));
        System.out.println(missingNumber(new int[]{0, 2, 3, 4}));
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了54.00%的用户
     */
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] + nums[end] == nums.length) {
                start++;
                end--;
            } else {
                return start != nums[start] ? start : ++end;
            }
        }
        return start;
    }
}
