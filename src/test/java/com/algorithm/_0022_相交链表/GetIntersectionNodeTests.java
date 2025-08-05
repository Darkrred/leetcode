package com.algorithm._0022_相交链表;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetIntersectionNodeTests {

    static class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    @Test
    void testIntersectingLists() {
        // 创建相交链表
        // listA: 1 -> 2 -> 3
        //                \
        //                 4 -> 5
        //                /
        // listB:   6 -> 7
        ListNode intersectionNode = new ListNode(4);
        intersectionNode.next = new ListNode(5);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = intersectionNode;

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = intersectionNode;

        Solution solution = new Solution();
        ListNode result = solution.getIntersectionNode(headA, headB);

        assertNotNull(result);
        assertEquals(4, result.val);
    }


    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA;
            ListNode p2 = headB;

            while (p1 != p2) {
                p1 = (p1 == null) ? headB : p1.next;
                p2 = (p2 == null) ? headA : p2.next;
            }

            return p1;
        }
    }
}
