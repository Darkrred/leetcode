package com.algorithm.柱状图中最大的矩形;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestRectangleAreaTests {
    @Test
    void testLargestRectangleArea() {
        Solution solution = new Solution();
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        assertEquals(10, solution.largestRectangleArea(heights));
    }


    static class Solution {
        int largestRectangleArea(int[] heights) {
            int max = 0;
            Deque<Integer> stack = new LinkedList<Integer>();

            int[] newHeights = new int[heights.length + 2];
            for (int i = 0; i < heights.length; i++)
                newHeights[i + 1] = heights[i];
            newHeights[0] = newHeights[heights.length + 1] = 0;

            for (int i = 0; i < newHeights.length; i++) {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = right - left - 1;
                        int h = newHeights[mid];
                        max = Math.max(max, w * h);
                    }
                }
                stack.push(i);
            }

            return max;
        }
    }
}
