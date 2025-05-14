package com.algorithm.快速排序法;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTests {

    @Test
    void testQuickSort() {
        Solution solution = new Solution();

        // 测试普通数组
        int[] arr1 = {5, 3, 8, 4, 2};
        int[] expected1 = {2, 3, 4, 5, 8};
        assertArrayEquals(expected1, solution.quickSort(arr1.clone()));

        // 测试单个元素
        int[] arr3 = {1};
        int[] expected3 = {1};
        assertArrayEquals(expected3, solution.quickSort(arr3.clone()));

        // 测试已排序数组
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] expected4 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected4, solution.quickSort(arr4.clone()));

        // 测试逆序数组
        int[] arr5 = {5, 4, 3, 2, 1};
        int[] expected5 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected5, solution.quickSort(arr5.clone()));

        // 测试重复元素
        int[] arr6 = {4, 4, 4, 4};
        int[] expected6 = {4, 4, 4, 4};
        assertArrayEquals(expected6, solution.quickSort(arr6.clone()));
    }

    static class Solution {
        public int[] quickSort(int[] nums) {
            quickSortHelper(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSortHelper(int[] nums, int low, int high) {
            if (low < high) {
                int pivot = partition(nums, low, high);
                quickSortHelper(nums, low, pivot - 1);
                quickSortHelper(nums, pivot + 1, high);
            }
        }

        private int partition(int[] nums, int low, int high) {
            int i = low;

            for (int j = low; j < high; j++) {
                if (nums[j] <= nums[high]) {
                    swap(nums, i, j);
                    i++;
                }
            }

            swap(nums, i, high);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}