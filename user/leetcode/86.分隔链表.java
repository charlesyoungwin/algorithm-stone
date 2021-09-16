/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                small.next = curr;
                small = small.next;
            } else {
                large.next = curr;
                large = large.next;
            }
            curr = curr.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
// @lc code=end

