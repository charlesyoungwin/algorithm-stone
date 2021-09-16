/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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

    private int res = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return res;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = traverse(root.left);
        int sumRight = traverse(root.right);
        res += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + root.val;
    }
}
// @lc code=end

