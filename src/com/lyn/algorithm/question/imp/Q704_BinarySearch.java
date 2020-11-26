package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Q704_BinarySearch implements IQuestion {

    @Override
    public String title() {
        return "二分查找";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/binary-search/";
    }

    @Override
    public void execute() {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 3));
        System.out.println(search(new int[]{5}, 5));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了95.74%的用户
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) {
            return -1;
        }

        int index = start + (end - start) / 2;

        if (target < nums[index]) {
            return search(nums, target, start, index - 1);
        } else if (target > nums[index]) {
            return search(nums, target, index + 1, end);
        } else {
            return index;
        }
    }
}
