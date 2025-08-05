package com.algorithm._0006_三数之和;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeSumTests {

    @Test
    void testThreeSum() {
        Solution solution = new Solution();
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> expected = List.of(
          Arrays.asList(-1, -1, 2),
          Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> actual = solution.threeSum(nums);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // { -4, -1, -1, 0, 1, 2 }

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        j++;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        while (j < k && nums[j + 1] == nums[j]) j++;
                        while (j < k && nums[k - 1] == nums[k]) k--;

                        j++;
                        k--;
                    }
                }
            }

            return result;
        }
    }
}
