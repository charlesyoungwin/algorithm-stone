/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode curr = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 == null) {
            curr.next= head2;
        }
        if (head2 == null) {
            curr.next = head1;
        }
        return dummyHead.next;
    }
}
// @lc code=end

