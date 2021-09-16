/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        ListNode mid = getMid(head, tail);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode node1 = sort(head, mid);
        ListNode node2 = sort(tmp, tail);
        return merge(node1, node2);
    }

    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        curr.next = node1 == null ? node2 : node1;
        return dummyHead.next;
    }
}
// @lc code=end

