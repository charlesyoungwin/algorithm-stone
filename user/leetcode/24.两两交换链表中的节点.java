/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            ListNode next = curr.next;
            ListNode nextNext = curr.next.next;
            next.next = nextNext.next;
            curr.next = nextNext;
            nextNext.next = next;
            curr = next;
        }
        return dummyHead.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = swapPairsRecursive(newHead.next);
        head.next = node;
        newHead.next = head;
        return newHead;
    }
}
// @lc code=end

