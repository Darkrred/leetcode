package com.algorithm._0019_螺旋矩阵;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpiralOrderTests {

    @Test
    void testSpiralOrder() {
        Solution solution = new Solution();
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> expect = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertTrue(expect.containsAll(actual));
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int left = 0, top = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;

            while (left <= right && top <= bottom) {

                for (int i = left; i <= right; i++)
                    result.add(matrix[top][i]);
                top++;
                if (top > bottom) break;

                for (int i = top; i <= bottom; i++)
                    result.add(matrix[i][right]);
                right--;
                if (left > right) break;

                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
                if (top > bottom) break;

                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
                if (top > bottom) break;
            }

            return result;
        }
    }
}
