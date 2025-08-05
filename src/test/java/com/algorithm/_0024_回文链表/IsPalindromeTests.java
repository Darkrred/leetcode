package com.algorithm._0024_回文链表;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindromeTests {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    void testIsPalindrome() {
        // 原始链表: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(head));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) return true;

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode prev = null;
            ListNode curr = slow.next;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode p1 = head;
            ListNode p2 = prev;

            while (p2 != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;
        }
    }
}
