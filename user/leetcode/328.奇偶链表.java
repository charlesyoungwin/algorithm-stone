/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode oddHead = oddNode;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        ListNode curr = head.next.next;
        int count = 1;
        while (curr != null) {
            if (count % 2 == 1) {
                oddNode.next = curr;
                oddNode = oddNode.next;
            } else {
                evenNode.next = curr;
                evenNode = evenNode.next;
            }
            curr = curr.next;
            count++;
        }
        evenNode.next = null;
        oddNode.next = evenHead;
        return oddHead;

    }
}
// @lc code=end

