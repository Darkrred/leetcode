package com.algorithm.单词拆分;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBreakTests {

    @Test
    void testWordBreak() {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        assertTrue(solution.wordBreak(s, wordDict));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            Arrays.fill(dp, false);
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
