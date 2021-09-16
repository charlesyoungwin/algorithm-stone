/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        int width = length / k;
        int rem = length % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode subHead = curr;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            result[i] = subHead;
        }
        return result;
    }
}
// @lc code=end

