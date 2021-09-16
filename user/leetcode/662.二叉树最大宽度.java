import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0));
        int res = Integer.MIN_VALUE;
        int firstPos = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AnnotatedNode node = queue.poll();
                if (i == 0) {
                    firstPos = node.pos;
                }
                if (node.treeNode.left != null) {
                    queue.offer(new AnnotatedNode(node.treeNode.left, node.pos * 2));
                }
                if (node.treeNode.right != null) {
                    queue.offer(new AnnotatedNode(node.treeNode.right, node.pos * 2 + 1));
                }
                res = Math.max(res, node.pos - firstPos + 1);
            }
        }
        return res;
    }

    class AnnotatedNode {
        public TreeNode treeNode;
        public int pos;

        public AnnotatedNode(TreeNode treeNode, int pos) {
            this.treeNode = treeNode;
            this.pos = pos;
        }
    }


}
// @lc code=end

