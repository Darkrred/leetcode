package com.algorithm._0005_盛最多水的容器;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAreaTests {

    @Test
    void testMaxArea() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        assertEquals(49, solution.maxArea(nums));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int result = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                result = Math.max(result, area);
                if (height[l] <= height[r]) {
                    l++;
                } else {
                    r--;
                }
            }

            return result;
        }
    }
}
