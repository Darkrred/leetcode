package com.algorithm._0003_最长连续序列;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestConsecutiveTests {

    @Test
    void testLongestConsecutive() {
        Solution solution = new Solution();
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        assertEquals(9, solution.longestConsecutive(nums));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, 1);
            }

            int maxLength = 0;

            for (int num : nums) {
                int length = 1;
                while (map.containsKey(num + 1)) {
                    length++;
                    num++;
                }
                maxLength = Math.max(maxLength, length);
            }

            return maxLength;
        }
    }
}
