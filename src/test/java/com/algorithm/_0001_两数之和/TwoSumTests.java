package com.algorithm._0001_两数之和;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTests {

    @Test
    void testTwoSum() {
        Solution solution = new Solution();
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        assertArrayEquals(new int[] { 0, 1 }, solution.twoSum(nums, target));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (numMap.containsKey(complement)) {
                    return new int[] { numMap.get(complement), i };
                }

                numMap.put(nums[i], i);
            }

            return new int[] {};
        }
    }
}
