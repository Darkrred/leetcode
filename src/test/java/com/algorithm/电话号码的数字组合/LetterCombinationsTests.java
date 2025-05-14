package com.algorithm.电话号码的数字组合;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LetterCombinationsTests {

    @Test
    void testLetterCombinations() {
        Solution solution = new Solution();

        // 测试输入 digits = "23"
        List<String> result = solution.letterCombinations("23");

        // 预期结果（按顺序生成）
        List<String> expected = Arrays.asList(
                "ad", "ae", "af",
                "bd", "be", "bf",
                "cd", "ce", "cf"
        );

        // 验证结果数量和内容
        assertEquals(9, result.size());
        assertEquals(expected, result);
    }

    static class Solution {
        private static final Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) return result;

            backtrack(digits, result, new StringBuilder(), 0);
            return result;
        }

        private void backtrack(String digits, List<String> result, StringBuilder path, int start) {
            if (start == digits.length()) {
                result.add(path.toString());
                return;
            }
            char digit = digits.charAt(start);
            String letters = phoneMap.get(digit);
            for (char letter : letters.toCharArray()) {
                path.append(letter);
                backtrack(digits, result, path, start + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}