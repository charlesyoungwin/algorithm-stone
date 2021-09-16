/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int[] result = new int[length];
        int index = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null) {
            if (fast == null) {
                result[index++] = 0;
                slow = slow.next;
                fast = slow;
                continue;
            }
            if (fast.val > slow.val) {
                result[index++] = fast.val;
                slow = slow.next;
                fast = slow;
            } else {
                fast = fast.next;
            }
        }
        return result;
    }
}
// @lc code=end

