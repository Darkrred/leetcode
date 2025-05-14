package com.algorithm.最长有效括号;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParenthesesTests {

    @Test
    void TestLongestValidParentheses() {
        Solution solution = new Solution();
        String s = ")()())";
        assertEquals(4, solution.longestValidParentheses(s));
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
            return maxLen;
        }
    }
}
