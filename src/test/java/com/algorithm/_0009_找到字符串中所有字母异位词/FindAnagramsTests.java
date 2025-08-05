package com.algorithm._0009_找到字符串中所有字母异位词;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindAnagramsTests {

    @Test
    void testFindAnagrams() {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expect = List.of(0, 6);
        List<Integer> actual = solution.findAnagrams(s, p);
        assertTrue(actual.containsAll(expect));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s.length() < p.length()) {
                return result;
            }

            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < p.length(); i++) {
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(0);
            }

            for (int i = 0; i < s.length() - p.length(); i++) {
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + p.length()) - 'a']++;

                if (Arrays.equals(sCount, pCount)) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }
}