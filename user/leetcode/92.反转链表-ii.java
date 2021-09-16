/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 头插法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;           
        }
        return dummyNode.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            curr = curr.next;
        }
        ListNode pre = curr;
        for (int i = left - 1; i <= right; i++) {
            curr = curr.next;
        }
        ListNode tail = curr;
        ListNode prev = tail;
        ListNode node = pre.next;
        while (node != tail) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        pre.next = prev;
        return dummyHead.next;
    }
}
// @lc code=end

