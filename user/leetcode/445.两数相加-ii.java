import java.util.Deque;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        while (l1 != null) {
            list1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!list1.isEmpty() || !list2.isEmpty() || carry != 0) {
            int val1 = list1.isEmpty() ? 0 : list1.pop();
            int val2 = list2.isEmpty() ? 0 : list2.pop();
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// @lc code=end

