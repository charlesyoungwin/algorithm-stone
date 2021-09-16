import org.graalvm.compiler.nodes.calc.FloatEqualsNode;

/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node last;

    public Node tail;

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.next == null) {
                tail = curr;
            }
            if (curr.child != null) {
                Node temp = curr.next;

                Node child = flatten(curr.child);
                curr.next = child;
                child.prev = curr;
                curr.child = null;

                if (tail != null && temp != null) {
                    tail.next = temp;
                    temp.prev = tail;
                    tail = null;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public Node flatten2(Node head) {
        if (head == null) {
            return head;
        }
        if (head.next == null && head.child == null) {
            last = head;
            return head;
        }
        if (head.child == null) {
            Node node = flatten(head.next);
            head.next = node;
            node.prev = head;
            return head;
        }
        Node preNext = head.next;
        Node node = flatten(head.child);
        head.next = node;
        node.prev = head;
        head.child = null;
        if (preNext != null && last != null) {
            Node currentLast = last;
            last.next = flatten(preNext);
            preNext.prev = currentLast;
        }
        return head;
    }


}
// @lc code=end

