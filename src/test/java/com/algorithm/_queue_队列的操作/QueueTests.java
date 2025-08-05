package com.algorithm._queue_队列的操作;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

class QueueTests {
    private final Queue<Character> queue = new LinkedList<>();;

    // 测试 offer 添加元素和 poll 移除元素的基本功能（FIFO）
    @Test
    void testOfferAndPoll() {
        assertTrue(queue.offer('A')); // 添加元素 A
        assertEquals('A', queue.poll()); // 移除并返回 A
        assertTrue(queue.isEmpty());
    }

    // 测试空队列时 poll 返回 null
    @Test
    void testPollEmptyQueue() {
        assertNull(queue.poll()); // 队列为空时返回 null
        assertTrue(queue.isEmpty()); // 队列仍为空（size = 0）
    }

    // 测试 peek 方法不改变队列状态
    @Test
    void testPeek() {
        queue.offer('B');
        assertEquals('B', queue.peek()); // 查看但不移除 B
        assertEquals(1, queue.size()); // 验证队列大小未变
        assertEquals('B', queue.peek()); // 二次查看仍为 B
    }

    // 测试多元素 FIFO 行为
    @Test
    void testMultipleElements() {
        queue.offer('A');
        queue.offer('B');
        queue.offer('C');

        assertEquals('A', queue.poll()); // 移除 A
        assertEquals('B', queue.poll()); // 移除 B
        assertEquals('C', queue.poll()); // 移除 C
        assertTrue(queue.isEmpty());
    }

    // 测试混合操作（offer/poll/peek）
    @Test
    void testMixedOperations() {
        queue.offer('X');
        queue.poll(); // 移除 X
        queue.offer('Y');
        queue.offer('Z');

        assertEquals('Y', queue.peek()); // 当前队首为 Y
        assertEquals(2, queue.size());
        queue.poll(); // 移除 Y
        assertEquals('Z', queue.peek());
    }

    // 测试插入 null 元素（仅限允许 null 的实现类如 LinkedList）
    @Test
    void testNullElement() {
        assertTrue(queue.offer(null)); // 插入 null
        assertNull(queue.poll()); // 移除并返回 null
        assertFalse(queue.contains(null)); // 确认 null 已被移除
    }

    // 测试队列容量限制（需替换为有界队列实现，如 ArrayBlockingQueue）
    @Test
    void testCapacityConstraint() {
        Queue<Integer> boundedQueue = new LinkedList<>(); // 注意：LinkedList 无容量限制
        for (int i = 0; i < 1000; i++) {
            assertTrue(boundedQueue.offer(i)); // 永远返回 true
        }
        assertEquals(1000, boundedQueue.size());
    }
}
