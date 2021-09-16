/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = list1;
        ListNode curr = list1;
        ListNode preANode = null;
        ListNode afterBNode = null;
        int count = 0;
        while (curr != null) {
            if (count == a - 1) {
                preANode = curr;
            }
            if (count == b + 1) {
                afterBNode = curr;
            }
            curr = curr.next;
            count++;
        }
        preANode.next = list2;
        ListNode node = list2;
        while (node.next != null) {
            node = node.next;
        }
        node.next = afterBNode;
        return dummyHead.next;
    }
}
// @lc code=end

