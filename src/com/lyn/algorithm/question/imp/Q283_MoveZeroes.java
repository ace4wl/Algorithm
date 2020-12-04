package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Q283_MoveZeroes implements IQuestion {
    @Override
    public String title() {
        return " 移动零";
    }

    @Override
    public String url() {
        return "：https://leetcode-cn.com/problems/move-zeroes";
    }

    @Override
    public void execute() {
        int[] arr = new int[]{0, 0, 1};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了31.70%的用户
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && nums[firstZero] != 0) {
                firstZero = i;
            } else if (nums[firstZero] == 0 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[firstZero];
                nums[firstZero] = temp;
                firstZero++;
            }
        }
    }

    /**
     * 执行用时：60 ms, 在所有 Java 提交中击败了5.16%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了37.06%的用户
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
