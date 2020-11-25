package com.lyn.algorithm.question.imp;

import com.lyn.algorithm.question.IQuestion;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Q20_ValidParentheses implements IQuestion {

    @Override
    public String title() {
        return "有效的括号";
    }

    @Override
    public String url() {
        return "https://leetcode-cn.com/problems/valid-parentheses";
    }

    @Override
    public void execute() {
        System.out.println(String.valueOf(isValid("()")));
        System.out.println(String.valueOf(isValid("()[]{}")));
        System.out.println(String.valueOf(isValid("(]")));
        System.out.println(String.valueOf(isValid("([)]")));
        System.out.println(String.valueOf(isValid("{[]}")));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了75.96%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了80.51%的用户
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }

            char top = stack.peek();
            if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{'))
                stack.pop();
            else {
                stack.push(c);
            }
        }

        return stack.size() == 0;
    }
}
