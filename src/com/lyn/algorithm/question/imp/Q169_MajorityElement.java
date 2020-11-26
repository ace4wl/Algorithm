package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Q169_MajorityElement implements IQuestion {
    @Override
    public String title() {
        return "多数元素";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/majority-element";
    }

    @Override
    public void execute() {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 摩尔投票
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了75.12%的用户
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                result = num;
            }

            if (num == result) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

    /**
     * 执行用时：18 ms, 在所有 Java 提交中击败了15.27%的用户
     * 内存消耗：43.7 MB, 在所有 Java 提交中击败了25.25%的用户
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return 0;
    }
}
