/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    ListNode dummyHead = new ListNode(0);
    int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
       
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = dummyHead;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ++size;
        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode node = new ListNode(val);
        node.next = prev.next;
        prev.next = node;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;

        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

}

class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

