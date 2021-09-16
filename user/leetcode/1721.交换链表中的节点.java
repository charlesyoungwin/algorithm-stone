/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode kthNode = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode lastKthNode = slow;
        int temp = kthNode.val;
        kthNode.val = lastKthNode.val;
        lastKthNode.val = temp;
        return head;
    }
}
// @lc code=end

