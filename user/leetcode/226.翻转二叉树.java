/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.right = leftTree;
        root.left = rightTree;
        return root;
    }   

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
// @lc code=end

