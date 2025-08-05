package com.algorithm._0011_滑动窗口最大值;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxSlidingWindowTests {

    @Test
    void testMaxSlidingWindow() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] expect = new int[] { 3, 3, 5, 5, 6, 7 };
        int[] actual = solution.maxSlidingWindow(nums, k);
        assertArrayEquals(actual, expect);
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] result = new int[n - k + 1];
            if (deque.peekFirst() != null) {
                result[0] = nums[deque.peekFirst()];
            }
            for (int i = k; i < n; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                if (deque.peekFirst() != null) {
                    if (deque.peekFirst() <= i - k) {
                        deque.pollFirst();
                    }
                }
                if (deque.peekFirst() != null) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }
}
