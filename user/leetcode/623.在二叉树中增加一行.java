import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while (!queue.isEmpty()) {
            if (height == depth - 1) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            height++;
        } 
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            node.left = new TreeNode(val);
            node.left.left = tempLeft;
            node.right = new TreeNode(val);
            node.right.right = tempRight;
        }
        return root;
    }
}
// @lc code=end

