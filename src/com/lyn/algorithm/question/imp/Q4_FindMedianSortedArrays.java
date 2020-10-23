package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

public class Q4_FindMedianSortedArrays implements IQuestion {

    @Override
    public String title() {
        return "寻找两个正序数组的中位数";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/median-of-two-sorted-arrays/";
    }

    @Override
    public void execute() {
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[0];
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了74.74%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了95.60%的用户
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] totalNums = new int[nums1.length + nums2.length];

        int p1 = 0, p2 = 0;

        for (int i = 0; i < totalNums.length; i++) {

            if (p1 == nums1.length) {
                totalNums[i] = nums2[p2];
                p2++;
                continue;
            }

            if (p2 == nums2.length) {
                totalNums[i] = nums1[p1];
                p1++;
                continue;
            }

            if (nums1[p1] > nums2[p2]) {
                totalNums[i] = nums2[p2];
                p2++;
            } else {
                totalNums[i] = nums1[p1];
                p1++;
            }
        }

        int middle = totalNums.length / 2;

        if (totalNums.length == 0) {
            return 0;
        } else if (totalNums.length % 2 == 0) {
            return (totalNums[middle - 1] + totalNums[middle]) / 2d;
        } else {
            return totalNums[middle];
        }
    }
}
