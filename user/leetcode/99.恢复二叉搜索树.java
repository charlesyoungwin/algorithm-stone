/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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

    private TreeNode prevNode;
    private TreeNode firstNode;
    private TreeNode secondNode;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp; 
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (prevNode != null) {
            if (root.val < prevNode.val) {
                if (firstNode == null) {
                    firstNode = prevNode;
                }
                secondNode = root;
            }
        }
        prevNode = root;
        traverse(root.right);

    }
}
// @lc code=end

