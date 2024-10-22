package interview_classic_150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 146 LRU缓存
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
 * key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1); // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2); // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1); // 返回 -1 (未找到)
 * lRUCache.get(3); // 返回 3
 * lRUCache.get(4); // 返回 4
 * 
 * 
 * 提示：
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */

public class LRU缓存 {

    // 使用哈希map来管理键值对
    // 使用一个容量变量来管理缓存大小
    // 对键的管理是采用序列结构
    // 一般来说，键的淘汰规则类似队列，先进先出
    // 但是存在某些键因为被调用需要被移到队尾
    // 对于这些键，如果按照冒泡排序那样和后面的元素一个一个调换移到队尾，效率太低
    // 因此链表会是一个很方便的结构
    // 但是单向链表无法达到O(1)，因为单向链表不提供前驱节点
    // 查找前驱节点需要遍历，遍历就是O(n)
    // 因此O(1)的复杂度需要双向链表实现
    class LRUCache {
        Map<Integer, Integer> table;
        List<Integer> queue;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.table = new HashMap<>();
            this.queue = new LinkedList<>();
        }

        public int get(int key) {
            if (table.containsKey(key)) {
                queue.remove(queue.indexOf(key));
                queue.add(key);
                return table.get(key);
            } else {
                return -1;
            }
        }

        // 超出时间限制
        // public void put(int key, int value) {
        // if (table.containsKey(key)) {
        // table.put(key, value);
        // queue.remove(queue.indexOf(key));
        // queue.add(key);
        // } else if (table.size() < capacity) { // 可能存在键存在，因此放在第二次判断
        // table.put(key, value);
        // queue.add(key);
        //
        // } else {
        // int flag = queue.remove(0);
        // table.remove(flag);
        // table.put(key, value);
        // queue.add(key);
        // }
        // for (int var : queue) {
        // System.out.print(var);
        // }
        // System.out.println();
        // }

        // public void put(int key, int value) {
        // if (table.size() < capacity) {
        // if (!table.containsKey(key)) {
        // table.put(key, value);
        // queue.add(key);
        // } else {
        // table.put(key, value);
        // queue.remove(queue.indexOf(key));
        // queue.add(key);
        // }
        // } else {
        // if (table.containsKey(key)) {
        // table.put(key, value);
        // queue.remove(queue.indexOf(key));
        // queue.add(key);
        //
        // } else {
        // table.remove(queue.remove(0));
        // table.put(key, value);
        // queue.add(key);
        //
        // }
        // }
        // for (int var : queue) {
        // System.out.print(var);
        // }
        // System.out.println();
        // }

        // 超出时间限制
        // public void put(int key, int value) {
        // if (table.containsKey(key)) {
        // table.put(key, value);
        // queue.remove(queue.indexOf(key));
        // queue.add(key);
        // } else {
        // if (table.size() < capacity) {
        // table.put(key, value);
        // queue.add(key);
        // } else {
        // table.remove(queue.remove(0));
        // table.put(key, value);
        // queue.add(key);
        // }
        // }
        // for (int var : queue) {
        // System.out.print(var);
        // }
        // System.out.println();
        // }

        public void put(int key, int value) {
            if (!table.containsKey(key)) {
                table.put(key, value);
                queue.add(key);
                if (table.size() > capacity) {
                    table.remove(queue.remove(0));
                }
            } else {
                table.put(key, value);
                queue.remove(queue.indexOf(key));
                queue.add(key);
            }
            for (int var : queue) {
                System.out.print(var);
            }
            System.out.println();
        }

    }

    // 双向链表 101ms 113.2MB
    class LRUCache2 {

        // 在双向链表中找键是个问题
        // 因此直接把链表放在map里，用map找键，链表放值
        class DlinkedNode {
            int val; // 由于存在键和值不一致，只保存值的时候，容易把值当键，而hashmap无法通过值找键，因此需要多设一个变量key
            int key;
            DlinkedNode pre;
            DlinkedNode next;

            public DlinkedNode() {

            }

            public DlinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public void addToHead(DlinkedNode node) {
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
        }

        public void remove(DlinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void moveToHead(DlinkedNode node) {
            remove(node);
            addToHead(node);
        }

        public int removeTail() {
            int ans = tail.pre.key;
            remove(tail.pre);
            return ans;
        }

        public Map<Integer, DlinkedNode> table;
        int capacity;
        DlinkedNode head;
        DlinkedNode tail;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            this.table = new HashMap<>();
            head = new DlinkedNode();
            tail = new DlinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!table.containsKey(key)) {
                return -1;
            } else {
                DlinkedNode node = table.get(key);
                moveToHead(node);
                return node.val;
            }
        }

        public void put(int key, int value) {
            DlinkedNode node = table.get(key);
            if (!table.containsKey(key)) { // 查找键的时间会比直接取键值久
                DlinkedNode fresh = new DlinkedNode(key, value);
                table.put(key, fresh);
                addToHead(fresh);
                if (table.size() > capacity) {
                    int a = removeTail();
                    table.remove(a);
                    System.out.println(a);
                }
            } else {
                node.val = value;
                moveToHead(node);
            }

            table.forEach((k, v) -> {
                System.out.print(" key: " + k + " value: " + v.val);
            });
            System.out.println();
        }
    }

    // 100ms 112.9MB
    public class LRUCache3 {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache3(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    @Test
    public void test() {
        LRUCache2 lRUCache = new LRUCache2(2);
        // 用例1
        // lRUCache.put(1, 1);
        // lRUCache.put(2, 2);
        // lRUCache.get(1);
        // lRUCache.put(3, 3);
        // lRUCache.get(2);
        // lRUCache.put(4, 4);
        // lRUCache.get(1);
        // lRUCache.get(3);
        // lRUCache.get(4);
        //
        // 用例2
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
        lRUCache.table.forEach((key, value) -> {
            System.out.println("key: " + key + ", value: " + value.val);
        });
    }
}
