package com.algorithm._0007_接雨水;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapTests {

    @Test
    void testTrap() {
        Solution solution = new Solution();
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        assertEquals(6, solution.trap(height));
    }

    static class Solution {
        public int trap(int[] height) {
            int sum = 0;
            if (height.length <= 2) return sum;
            Deque<Integer> stack = new LinkedList<>();

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = right - left - 1;
                        int h = Math.min(height[right], height[left]) - height[mid];
                        int s = w * h;
                        sum += s;
                    }
                }
                stack.push(i);
            }

            return sum;
        }
    }
}
