package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3_LengthOfLongestSubstring implements IQuestion {

    @Override
    public String title() {
        return "无重复字符的最长子串";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/";
    }

    @Override
    public void execute() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring_v1(""));
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了86.60%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了99.42%的用户
     */
    public int lengthOfLongestSubstring(String s) {
        List<Character> characters = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (characters.contains(c)) {
                max = Math.max(max, characters.size());
                while (true) {
                    if (characters.remove(0).equals(c))
                        break;
                }
            }

            characters.add(c);
        }

        return Math.max(max, characters.size());
    }

    /**
     * 执行用时：95 ms, 在所有 Java 提交中击败了17.60%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了19.42%的用户
     */
    public int lengthOfLongestSubstring_v1(String s) {
        Set<Character> set = new HashSet<>();
        int ret = 0;
        int start = 0;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                ret = Math.max(ret, set.size());
                set.clear();
                i = start++;
            } else {
                set.add(c);
            }
        }
        return Math.max(ret, set.size());
    }
}
