package com.algorithm.最长递增子序列;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLISTests {

    @Test
    void testLenthOfLIS() {
        Solution solution = new Solution();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        assertEquals(4, solution.lengthOfLIS(nums));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int result = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }
}
