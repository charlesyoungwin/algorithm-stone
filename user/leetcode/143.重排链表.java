/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode endFirstHalfNode = getEndOfFirstHalf(head);
        ListNode newHead = reverse(endFirstHalfNode.next);
        endFirstHalfNode.next = null;
        ListNode firstHead = head;
        ListNode curr = dummyHead;
        while (newHead != null) {
            ListNode firstNext = firstHead.next;
            ListNode secondNext = newHead.next;
            curr.next = firstHead;
            curr.next.next = newHead;
            firstHead = firstNext;
            newHead = secondNext;
            curr = curr.next.next;
        }
        curr.next = firstHead;
    }

    private ListNode getEndOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
// @lc code=end

