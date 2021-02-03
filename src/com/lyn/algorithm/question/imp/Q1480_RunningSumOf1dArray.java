package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 */
public class Q1480_RunningSumOf1dArray implements IQuestion {

    @Override
    public String title() {
        return "一维数组的动态和";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/running-sum-of-1d-array/";
    }

    @Override
    public void execute() {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了25.73%的用户
     */
    private int[] runningSum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了11.27%的用户
     */
    private int[] runningSum1(int[] nums) {
        int[] ret = new int[nums.length];
        if (ret.length == 0) return ret;
        ret[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] + nums[i];
        }
        return ret;
    }
}
