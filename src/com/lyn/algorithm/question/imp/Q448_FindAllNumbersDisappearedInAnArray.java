package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class Q448_FindAllNumbersDisappearedInAnArray implements IQuestion {

    @Override
    public String title() {
        return "找到所有数组中消失的数字";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array";
    }

    @Override
    public void execute() {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了64.16%的用户
     * 内存消耗：47.3 MB, 在所有 Java 提交中击败了66.73%的用户
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //拿到索引的值
            int val = nums[i];
            //根据val标记索引的值（标为负数），证明该值存在
            val = Math.abs(val) - 1;
            nums[val] = Math.abs(nums[val]) * -1;
        }

        //最终目的是遍历索引，根据索引的值的标记判断该索引在值数组里是否存在
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
