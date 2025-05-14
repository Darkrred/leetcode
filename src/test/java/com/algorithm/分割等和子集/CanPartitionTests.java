package com.algorithm.分割等和子集;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanPartitionTests {

    @Test
    void testCanPartition() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 5, 11, 5 };
        assertTrue(solution.canPartition(nums));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % 2 != 0)
                return false;
            int target = sum / 2;

            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] |= dp[i - num];
                }
            }
            return dp[target];
        }
    }
}
