/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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

    private int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight= getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diameter = leftHeight + rightHeight;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    public int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), 
            getHeight(root.right)) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        height(root);
        return res;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        res = Math.max(res, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// @lc code=end

