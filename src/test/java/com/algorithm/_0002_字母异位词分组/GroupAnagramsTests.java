package com.algorithm._0002_字母异位词分组;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramsTests {

    @Test
    void testGroupAnagrams() {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> actual = solution.groupAnagrams(strs);

        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("bat")));
        expected.add(new ArrayList<>(Arrays.asList("nat", "tan")));
        expected.add(new ArrayList<>(Arrays.asList("ate", "eat", "tea")));

        sortResult(actual);
        sortResult(expected);

        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    private void sortResult(List<List<String>> result) {
        for (List<String> group : result) {
            Collections.sort(group);
        }

        result.sort(Comparator.comparing(group -> group.get(0)));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());

                map.get(key).add(s);
            }

            return new ArrayList<>(map.values());
        }
    }
}