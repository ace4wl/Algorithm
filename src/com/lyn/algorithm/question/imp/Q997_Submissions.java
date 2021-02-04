package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

/**
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * <p>
 * 如果小镇的法官真的存在，那么：
 * <p>
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 */
public class Q997_Submissions implements IQuestion {

    @Override
    public String title() {
        return "找到小镇的法官";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/find-the-town-judge/";
    }

    @Override
    public void execute() {
        System.out.println(findJudge(2, new int[][]{
                {1, 2}
        }));
        System.out.println(findJudge(3, new int[][]{
                {1, 3}, {2, 3}
        }));
        System.out.println(findJudge(3, new int[][]{
                {1, 3}, {2, 3}, {3, 1}
        }));
        System.out.println(findJudge(3, new int[][]{
                {1, 2}, {2, 3}
        }));
        System.out.println(findJudge(4, new int[][]{
                {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}
        }));
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了67.17%的用户
     * 内存消耗：45.8 MB, 在所有 Java 提交中击败了88.13%的用户
     */
    private int findJudge(int N, int[][] trust) {
        int[] arr = new int[N];

        for (int[] i : trust) {
            //信任别人-1
            arr[i[0] - 1]--;
            //被信任+1
            arr[i[1] - 1]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == N - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
