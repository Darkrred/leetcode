package com.algorithm.组合总数;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GenerateParenthesisTests {

    @Test
    void testGenerateParenthesis() {
        Solution solution = new Solution();

        // 测试 n=3 的情况
        List<String> result = solution.generateParenthesis(3);

        // 预期结果（共5种）
        List<String> expected = Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        );

        // 验证数量和内容
        assertEquals(5, result.size());
        assertTrue(result.containsAll(expected));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(n, result, "", 0, 0);
            return result;
        }

        private void backtrack(int n, List<String> result, String path, int open, int close) {
            if (path.length() == n * 2) {
                result.add(path);
                return;
            }

            if (open < n) backtrack(n, result, path + "(", open + 1, close);
            if (close < open) backtrack(n, result, path + ")", open, close + 1);
        }
    }
}