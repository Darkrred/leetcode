package com.algorithm._0020_旋转图像;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateTests {

    @Test
    void testRotate() {
        Solution solution = new Solution();
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] expect = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        solution.rotate(matrix);
        assertArrayEquals(expect, matrix);
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
}
