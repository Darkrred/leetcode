package com.algorithm._0008_无重复字符的最长子串;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLongestSubstringTests {
    @Test
    void testLengthOfLongestSubstring() {
        Solution solution = new Solution();
        String s = "abcabcbb";
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            if (s == null) return result;

            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int left = 0;

            for (int right = left; right < chars.length; right++) {
                while (set.contains(chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[right]);
                result = Math.max(result, right - left + 1);
            }

            return result;
        }
    }
}
