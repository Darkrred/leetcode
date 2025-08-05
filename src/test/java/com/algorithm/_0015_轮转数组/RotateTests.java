package com.algorithm._0015_轮转数组;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateTests {

    @Test
    void testRotate() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        solution.rotate(nums, k);
        assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, nums);
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            if (k == 0) return;
            k %= n;

            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
