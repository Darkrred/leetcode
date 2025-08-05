package com.algorithm._0014_合并区间;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTests {

    @Test
    void testMerge() {
        Solution solution = new Solution();
        int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expect = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] actual = solution.merge(intervals);
        assertArrayEquals(expect, actual);
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> merged = new ArrayList<>();
            merged.add(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                int[] current = intervals[i];
                int[] last = merged.get(merged.size() - 1);

                if (current[0] <= last[1]) {
                    last[1] = Math.max(current[1], last[1]);
                } else {
                    merged.add(current);
                }
            }

            return merged.toArray(new int[merged.size()][]);
        }
    }
}