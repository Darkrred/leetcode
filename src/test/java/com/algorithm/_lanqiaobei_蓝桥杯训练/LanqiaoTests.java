package com.algorithm._lanqiaobei_蓝桥杯训练;

import java.util.*;

class LanqiaoTests {
    public static class TwoPointersTest {
        public static int minDeletions(int[] arr) {
            int[] count = new int[10];
            for (int num : arr) {
                count[num % 10]++;
            }
            int left = 0, right = 0, res = Integer.MAX_VALUE;
            while (right < 10) {
                while (right < 10 && count[right] == 0) right++;
                if (right >= 10) break;
                int current = count[right];
                right++;
                while (right < 10 && count[right] != 0 && count[right] < current) {
                    current += count[right];
                    right++;
                }
                res = Math.min(res, arr.length - current);
            }
            return res;
        }

        public static void main(String[] args) {
            int[] arr = {11, 121, 22, 12, 2023};
            System.out.println("最小删除次数: " + minDeletions(arr));
        }
    }

    public static class HeapTest {
        // 找出数组中最大的K个数（最小堆）
        public static int[] topK(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int num : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(num);
                } else if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = minHeap.poll();
            }
            return result;
        }

        public static void main(String[] args) {
            int[] nums = {3, 1, 5, 12, 2, 11};
            int k = 3;
            System.out.println("Top 3元素: " + Arrays.toString(topK(nums, k)));
        }
    }

    public static class StackTest {
        // 检查括号是否合法
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == ']' && top != '[') ||
                            (c == '}' && top != '{')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public static void main(String[] args) {
            String s = "{[()]}";
            System.out.println("括号是否合法: " + isValid(s));
        }
    }

    public static class BinarySearchTest {
        // 分巧克力的最大边长
        public static int maxChocolateSize(int[][] chocolates, int k) {
            int left = 1, right = 100000;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canCut(chocolates, mid, k)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }

        private static boolean canCut(int[][] chocolates, int size, int k) {
            int count = 0;
            for (int[] choco : chocolates) {
                count += (choco[0] / size) * (choco[1] / size);
                if (count >= k) return true;
            }
            return false;
        }

        public static void main(String[] args) {
            int[][] chocolates = {{6,5}, {5,6}};
            int k = 10;
            System.out.println("最大边长: " + maxChocolateSize(chocolates, k));
        }
    }

    public static class DFSTest {
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private static int maxSteps = 0;

        // 迷宫最长路径
        public static void findLongestPath(int[][] maze, int x, int y, int steps) {
            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1) {
                return;
            }
            maxSteps = Math.max(maxSteps, steps);
            maze[x][y] = 1;
            for (int[] dir : DIRS) {
                findLongestPath(maze, x + dir[0], y + dir[1], steps + 1);
            }
            maze[x][y] = 0;
        }

        public static void main(String[] args) {
            int[][] maze = {
                    {0,0,0,0},
                    {1,1,0,1},
                    {0,0,0,0},
                    {0,1,1,0}
            };
            findLongestPath(maze, 0, 0, 0);
            System.out.println("最长路径步数: " + maxSteps);
        }

        public static class BFSTest {
            private static class Node {
                int x, y, steps;
                Node(int x, int y, int steps) {
                    this.x = x;
                    this.y = y;
                    this.steps = steps;
                }
            }

            // 迷宫最短路径
            public static int shortestPath(int[][] maze, int[] start, int[] end) {
                Queue<Node> queue = new LinkedList<>();
                boolean[][] visited = new boolean[maze.length][maze[0].length];
                queue.offer(new Node(start[0], start[1], 0));
                visited[start[0]][start[1]] = true;

                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    if (curr.x == end[0] && curr.y == end[1]) {
                        return curr.steps;
                    }
                    for (int[] dir : DFSTest.DIRS) {
                        int newX = curr.x + dir[0];
                        int newY = curr.y + dir[1];
                        if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length
                                && maze[newX][newY] == 0 && !visited[newX][newY]) {
                            visited[newX][newY] = true;
                            queue.offer(new Node(newX, newY, curr.steps + 1));
                        }
                    }
                }
                return -1; // 不可达
            }

            public static void main(String[] args) {
                int[][] maze = {
                        {0,0,0,0},
                        {1,1,0,1},
                        {0,0,0,0},
                        {0,1,1,0}
                };
                int[] start = {0,0}, end = {3,3};
                System.out.println("最短路径步数: " + shortestPath(maze, start, end));
            }
        }

        public static class BacktrackTest {
            public static List<List<Integer>> permute(int[] nums) {
                List<List<Integer>> result = new ArrayList<>();
                backtrack(result, new ArrayList<>(), nums);
                return result;
            }

            private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
                if (temp.size() == nums.length) {
                    result.add(new ArrayList<>(temp));
                    return;
                }
                for (int num : nums) {
                    if (temp.contains(num)) continue;
                    temp.add(num);
                    backtrack(result, temp, nums);
                    temp.remove(temp.size() - 1);
                }
            }

            public static void main(String[] args) {
                int[] nums = {1,2,3};
                System.out.println("全排列: " + permute(nums));
            }
        }

        public static class GreedyTest {
            public static int maxActivities(int[][] activities) {
                Arrays.sort(activities, (a, b) -> a[1] - b[1]);
                int count = 1, lastEnd = activities[0][1];
                for (int i = 1; i < activities.length; i++) {
                    if (activities[i][0] >= lastEnd) {
                        count++;
                        lastEnd = activities[i][1];
                    }
                }
                return count;
            }

            public static void main(String[] args) {
                int[][] activities = {{1,4}, {3,5}, {0,6}, {5,7}, {3,8}, {5,9}, {6,10}, {8,11}, {8,12}, {2,13}, {12,14}};
                System.out.println("最大活动数: " + maxActivities(activities));
            }
        }

        public static class DPTest {
            public static int lengthOfLIS(int[] nums) {
                int[] dp = new int[nums.length];
                Arrays.fill(dp, 1);
                int maxLen = 1;
                for (int i = 1; i < nums.length; i++) {
                    for (int j = 0; j < i; j++) {
                        if (nums[i] > nums[j]) {
                            dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
                return maxLen;
            }

            public static void main(String[] args) {
                int[] nums = {10,9,2,5,3,7,101,18};
                System.out.println("LIS长度: " + lengthOfLIS(nums));
            }
        }
    }
}
