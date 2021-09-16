import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Map<Node, Node> cacheNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (!cacheNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random  = map.get(curr.random);
            curr = curr.next;
        }   
        return map.get(head);
    }
}
// @lc code=end

