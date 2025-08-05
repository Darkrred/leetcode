package com.algorithm._stack_栈的操作;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DequeTests {

    // 使用 LinkedList 作为 Deque 的实现类
    private final Deque<Character> stack = new LinkedList<>();

    // 测试 push 和 pop 的基本功能（LIFO）
    @Test
    void testPushAndPop() {
        stack.push('A');
        stack.push('B');
        stack.push('C');

        assertEquals('C', stack.pop()); // 最后压入的 C 应最先弹出
        assertEquals('B', stack.pop());
        assertEquals('A', stack.pop());
    }

    // 测试 peek 方法不改变队列状态
    @Test
    void testPeek() {
        stack.push('A');
        stack.push('B');

        assertEquals('B', stack.peek()); // 查看但不弹出
        assertEquals('B', stack.peek()); // 二次查看应保持原值
        assertEquals(2, stack.size());   // 验证队列大小未变
    }

    // 测试空队列 pop 时抛出异常
    @Test
    void testPopOnEmptyDeque() {
        assertThrows(NoSuchElementException.class, stack::pop);
    }

    // 测试混合操作（push/poll/size）
    @Test
    void testMixedOperations() {
        stack.addFirst('X');  // 队列：[X]
        stack.addLast('Y');   // 队列：[X, Y]
        stack.push('Z');      // 队列：[Z, X, Y]（等效于 addFirst）

        assertEquals('Z', stack.poll()); // 弹出 Z，队列：[X, Y]
        assertEquals('X', stack.removeFirst()); // 移除 X，队列：[Y]
        assertEquals(1, stack.size());
        assertEquals('Y', stack.peekLast()); // 查看最后一个元素 Y
    }

    // 测试从头部和尾部添加/删除元素
    @Test
    void testAddAndRemoveFromBothEnds() {
        stack.addFirst('A');
        stack.addLast('B');
        stack.offerFirst('C');  // 等效于 addFirst
        stack.offerLast('D');   // 等效于 addLast

        assertEquals('C', stack.getFirst());
        assertEquals('D', stack.getLast());
        assertEquals(4, stack.size());

        stack.removeFirst();
        stack.removeLast();
        assertEquals(2, stack.size());
        assertEquals('A', stack.getFirst());
        assertEquals('B', stack.getLast());
    }

    // 测试队列为空时的异常场景
    @Test
    void testEmptyQueueChecks() {
        assertTrue(stack.isEmpty());

        assertThrows(NoSuchElementException.class, stack::remove);
        assertNull(stack.pollFirst());
        assertNull(stack.pollLast());
    }
}