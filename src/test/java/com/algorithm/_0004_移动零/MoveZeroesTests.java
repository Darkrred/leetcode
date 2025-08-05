package com.algorithm._0004_移动零;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTests {

    @Test
    void testMoveZeroes() {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums);
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int cur = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[cur] = nums[i];
                    cur++;
                }
            }
            for (int i = cur; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
