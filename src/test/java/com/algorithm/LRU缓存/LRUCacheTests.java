package com.algorithm.LRU缓存;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTests {

    static class LRUCache {
        static class DLinkNode {
            int key;
            int value;
            DLinkNode prev;
            DLinkNode next;

            public DLinkNode() {}
            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final Map<Integer, DLinkNode> cache = new HashMap<>();
        private int size;
        private final int capacity;
        private final DLinkNode head;
        private final DLinkNode tail;


        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
            if (node == null) return -1;

            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);

            if (node == null) {
                DLinkNode newNode = new DLinkNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                ++size;

                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkNode removeTail() {
            DLinkNode temp = tail.prev;
            removeNode(temp);
            return temp;
        }
    }

    private LRUCache cache;

    @BeforeEach
    void setUp() {
        // 每个测试前初始化容量为2的缓存
        cache = new LRUCache(2);
    }

    @Test
    void testBasicOperations() {
        // 测试基本存取
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));       // 返回 1
        assertEquals(2, cache.get(2));       // 返回 2

        cache.put(3, 3);                              // 该操作会使得密钥 1 作废
        assertEquals(-1, cache.get(1));      // 返回 -1 (未找到)
        assertEquals(2, cache.get(2));       // 返回 3
    }

    @Test
    void testUpdateExistingKey() {
        // 测试更新现有键的值
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);                    // 更新键1的值

        cache.put(3, 3);                     // 此时应该淘汰键2

        assertEquals(10, cache.get(1));      // 已更新值
        assertEquals(-1, cache.get(2));      // 被淘汰
        assertEquals(3, cache.get(3));       // 新加入
    }

    @Test
    void testAccessOrder() {
        // 测试访问顺序
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);                        // 访问1，使2成为最近最少使用
        cache.put(3, 3);                     // 应该淘汰键2

        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    void testSingleCapacity() {
        // 测试容量为1的情况
        cache = new LRUCache(1);

        cache.put(1, 1);
        assertEquals(1, cache.get(1));

        cache.put(2, 2);               
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    void testMultipleAccesses() {
        // 测试多次访问后的淘汰顺序
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);                        // [1,2] -> [2,1]
        cache.put(3, 3);                     // 淘汰键2

        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));

        cache.get(3);                        // [1,3] -> [3,1]
        cache.put(4, 4);                     // 淘汰键1

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

}
