/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode curr = dummy;
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }
        curr = dummy;
        sum = 0;
        while (curr != null) {
            sum += curr.val;
            curr.next = map.get(sum).next;
            curr = curr.next;
        }
        return dummy.next;

    }
}
// @lc code=end

