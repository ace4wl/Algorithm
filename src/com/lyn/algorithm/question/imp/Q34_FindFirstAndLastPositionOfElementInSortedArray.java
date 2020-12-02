package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Q34_FindFirstAndLastPositionOfElementInSortedArray implements IQuestion {

    @Override
    public String title() {
        return "在排序数组中查找元素的第一个和最后一个位置";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array";
    }

    @Override
    public void execute() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[0], 0)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了53.76%的用户
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int firIndex = -1;
        int endIndex = -1;

        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            int midValue = nums[midIndex];

            if (target > midValue) {
                start = midIndex + 1;
            } else if (target < midValue) {
                end = midIndex - 1;
            } else {
                firIndex = midIndex;
                end = midIndex - 1;
            }
        }

        // 未查询到
        if (firIndex == -1) {
            return new int[]{-1, -1};
        }

        start = firIndex;
        end = nums.length - 1;

        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            int midValue = nums[midIndex];

            if (target > midValue) {
                start = midIndex + 1;
            } else if (target < midValue) {
                end = midIndex - 1;
            } else {
                endIndex = midIndex;
                start = midIndex + 1;
            }
        }


        return new int[]{firIndex, endIndex};
    }

}
