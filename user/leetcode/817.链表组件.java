/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
    public int numComponents(ListNode head, int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                res++;
                while (curr != null && set.contains(curr.val)) {
                    curr = curr.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return res;
    }
}
// @lc code=end

