import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    class ListNode {
        private int key;
        private int value;
        ListNode prev;
        ListNode next;
        public ListNode() {

        };

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, ListNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(ListNode node) {
        ListNode prevHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = prevHead;
        prevHead.prev = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(ListNode node) {
       removeNode(node);
       addToHead(node);
    }

    private ListNode removeTail() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

