package com.algorithm.字符串解码;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DecodeStringTests {

    private final Solution solution = new Solution();

    @Test
    void testBasicCase() {
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
    }

    @Test
    void testNestedCase() {
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
    }

    @Test
    void testMultipleCase() {
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }

    static class Solution {
        public String decodeString(String s) {
            Deque<Integer> numStack = new LinkedList<>();
            Deque<StringBuilder> strStack = new LinkedList<>();
            StringBuilder current = new StringBuilder();
            int num = 0;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else if (c == '[') {
                    numStack.push(num);
                    strStack.push(current);
                    current = new StringBuilder();
                    num = 0;
                } else if (c == ']') {
                    int repeat = numStack.pop();
                    StringBuilder temp = current;
                    current = strStack.pop();
                    current.append(String.valueOf(temp).repeat(repeat));
                } else {
                    current.append(c);
                }
            }

            return current.toString();
        }
    }
}