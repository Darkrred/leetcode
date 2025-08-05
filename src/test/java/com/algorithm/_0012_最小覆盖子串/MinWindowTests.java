package com.algorithm._0012_最小覆盖子串;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinWindowTests {

    @Test
    void testMinWindow() {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertEquals("BANC", solution.minWindow(s, t));
    }

    static class Solution {
        public String minWindow(String s, String t) {
            char[] S = s.toCharArray();
            char[] T = t.toCharArray();
            int n = S.length;
            int left = -1;
            int right = n;
            int[] countS = new int[128];
            int[] countT = new int[128];

            for (char c : T) {
                countT[c]++;
            }

            int l = 0;
            for (int r = 0; r < n; r++) {
                countS[S[r]]++;

                while (isInclude(countS, countT)) {
                    if (r - l < right - left) {
                        right = r;
                        left = l;
                    }
                    countS[S[l]]--;
                    l++;
                }
            }

            return left < 0 ? "" : s.substring(left, right + 1);
        }

        public boolean isInclude(int[] countS, int[] countT) {
            for (int i = 0; i < 128; i++) {
                if (countS[i] < countT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
