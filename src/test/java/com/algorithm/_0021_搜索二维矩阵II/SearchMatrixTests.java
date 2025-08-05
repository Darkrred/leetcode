package com.algorithm._0021_搜索二维矩阵II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchMatrixTests {

    @Test
    void testSearchMatrix() {
        Solution solution = new Solution();
        int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 },
                                       { 2, 5, 8, 12, 19 },
                                       { 3, 6, 9, 16, 22 },
                                       { 10, 13, 14, 17, 24 },
                                       { 18, 21, 23, 26, 30 } };
        int target = 5;
        assertTrue(solution.searchMatrix(matrix, target));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0;
            int j = matrix[0].length - 1;

            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }

            return false;
        }
    }
}
