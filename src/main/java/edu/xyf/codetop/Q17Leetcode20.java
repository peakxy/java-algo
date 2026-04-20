package edu.xyf.codetop;

import java.util.Stack;

/**
 * @Author: Xuyifeng
 * @Description: 有效的括号
 * @Date: 2026/4/14 13:55
 */

public class Q17Leetcode20 {

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    private char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }

}
