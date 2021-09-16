import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=1609 lang=java
 *
 * [1609] 奇偶树
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean even = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prevNode = null;
    
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (even) {
                    if (node.val % 2 == 0) {
                        return false;
                    }
                    if (prevNode != null) {
                        if (node.val <= prevNode.val) {
                            return false;
                        }
                    }
                } else {
                    if (node.val % 2 == 1) {
                        return false;
                    }
                    if (prevNode != null) {
                        if (node.val >= prevNode.val) {
                            return false;
                        }
                    }
                }
                prevNode = node;
                if (node.left != null) {
                    queue.offer(node.left);
                } 
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            even = !even;
        }
        return true;
    }
}
// @lc code=end

