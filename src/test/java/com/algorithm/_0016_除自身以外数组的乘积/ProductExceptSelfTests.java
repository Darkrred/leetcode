package com.algorithm._0016_除自身以外数组的乘积;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductExceptSelfTests {

    @Test
    void testProductExceptSelf() {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 2, 3, 4 };
        assertArrayEquals(new int[] { 24, 12, 8, 6 }, solution.productExcepeSelf(nums));
    }

    static class Solution {
        public int[] productExcepeSelf(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            int leftProduct = 1;
            for (int i = 0; i < n; i++) {
                result[i] = leftProduct;
                leftProduct *= nums[i];
            }

            int rightProduct = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] *= rightProduct;
                rightProduct *= nums[i];
            }

            return result;
        }
    }
}
