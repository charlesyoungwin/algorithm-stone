/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        int shift = length - k;
        curr = head;
        for (int i = 1; i < shift; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return next;

    }
}
// @lc code=end

