/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        ListNode nextNode;
        while ((nextNode = hasKNodes(curr, k)) != null) {
            ListNode currNext = curr.next;
            ListNode newHead = reverseKNodes(nextNode.next, currNext, k);
            curr.next = newHead;
            curr = currNext;
        }
        return dummyHead.next;
    }

    public ListNode hasKNodes(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
        }
        return curr;
    }

    public ListNode reverseKNodes(ListNode nextHead, ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = nextHead;
        ListNode next; 
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// @lc code=end

