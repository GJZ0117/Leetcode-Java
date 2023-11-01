package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 */

public class LRUCache {

    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            this.size++;
            if (this.size > this.capacity) {
                DoubleLinkedNode tail = removeTail();
                cache.remove(tail.key);
                this.size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}
