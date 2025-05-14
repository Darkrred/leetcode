package com.algorithm.跳跃游戏II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpTests {
    @Test
    void testJump() {
        Solution solution = new Solution();
        int[] nums = new int[] { 2, 2, 1, 1, 4 };
        assertEquals(3, solution.jump(nums));
    }


    static class Solution {
        public int jump(int[] nums) {
            int jumps = 0;
            int maxReach = 0;
            int currentReach = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                maxReach = Math.max(maxReach, i + nums[i]);
                if (i == currentReach) {
                    jumps++;
                    currentReach = maxReach;
                    if (currentReach >= nums.length - 1) break;
                }
            }

            return jumps;
        }
    }
}
