/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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

    private TreeNode prevNode = null;

    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (prevNode != null) {
            int val = Math.abs(prevNode.val - root.val);
            res = Math.min(res, val);
        }
        prevNode = root;
        traverse(root.right);

    }

}
// @lc code=end

