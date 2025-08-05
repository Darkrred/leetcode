package com.algorithm._0013_最大子数组和;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubArrayTests {

    @Test
    void testMaxSubArray() {
        Solution solution = new Solution();
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        assertEquals(6, solution.maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int currentMax = nums[0];
            int globalMax = nums[0];

            for (int i = 1; i < nums.length; i++) {
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                globalMax = Math.max(globalMax, currentMax);
            }

            return globalMax;
        }
    }
}
