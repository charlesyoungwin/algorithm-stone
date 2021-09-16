/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int val = val1 + val2 + carry;
            if (val >= 10) {
                val = val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
// @lc code=end

