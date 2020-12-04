package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Arrays;

/**
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * <p>
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * <p>
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * <p>
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * <p>
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * <p>
 *  
 */
public class Q1103_DistributeCandiesToPeople implements IQuestion {

    @Override
    public String title() {
        return "分糖果 II";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/distribute-candies-to-people/";
    }

    @Override
    public void execute() {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
        System.out.println(Arrays.toString(distributeCandies(1, 0)));
        System.out.println(Arrays.toString(distributeCandies(4, 1)));
    }

    /**
     * 非最优解，有数学方法。
     * 执行用时：1 ms, 在所有 Java 提交中击败了89.65%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了97.57%的用户
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];

        if (candies == 0 || num_people == 0) {
            return ret;
        }

        int remain = candies;
        int base = 0;

        while (remain > 0) {
            for (int i = 0; i < num_people; i++) {
                if (++base > remain) {
                    ret[i] += remain;
                    remain = 0;
                } else {
                    ret[i] += base;
                    remain -= base;
                }
            }
        }

        return ret;
    }
}
