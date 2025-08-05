package com.algorithm._0010_和为K的子数组;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarraySumTests {

    @Test
    void testSubarraySum() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 1, 1 };
        int k = 2;
        assertEquals(2, solution.subarraySum(nums, k));
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, 1);
            int prefixSum = 0;
            int count = 0;

            for (int num : nums) {
                prefixSum += num;
                count += prefixMap.getOrDefault(prefixSum - k, 0);
                prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
            }

            return count;
        }
    }
}
