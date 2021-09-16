import java.util.Queue;

/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<ANode> queue = new LinkedList<>();
        queue.offer(new ANode(root, 1));
        ANode lastNode = null;
        int size = 0;
        while (!queue.isEmpty()) {
            ANode anode = queue.poll();
            lastNode = anode;
            size++;
            if (anode.node.left != null) {
                queue.offer(new ANode(anode.node.left, anode.pos * 2));
            }
            if (anode.node.right != null) {
                queue.offer(new ANode(anode.node.right, anode.pos * 2 + 1));
            }
        }
        return lastNode.pos == size;
    }

    class ANode {
        public TreeNode node;
        public int pos;

        public ANode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

}
// @lc code=end

