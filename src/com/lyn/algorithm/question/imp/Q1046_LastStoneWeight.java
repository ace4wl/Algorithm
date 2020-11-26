package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class Q1046_LastStoneWeight implements IQuestion {

    @Override
    public String title() {
        return "最后一块石头的重量";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/last-stone-weight";
    }

    @Override
    public void execute() {
        System.out.println(lastStoneWeight(new int[]{1, 3}));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.7 MB, 在所有 Java 提交中击败了89.33%的用户
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        for (int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
        }

        return stones[stones.length - 1];
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了80.26%的用户
     */
    public int lastStoneWeight1(int[] stones) {
        if (stones == null) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }


        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }

        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }

        Arrays.sort(stones);
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;

        return lastStoneWeight(stones);
    }
}
