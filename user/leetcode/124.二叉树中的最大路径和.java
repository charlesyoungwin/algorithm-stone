/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxOneSide(root);
        return ans;
    }

    public int maxOneSide(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxOneSide(root.left);
        int right = maxOneSide(root.right);
        int path = left + root.val;
        path = Math.max(path, right + root.val);
        path = Math.max(path, root.val);

        ans = Math.max(ans, path);
        ans = Math.max(ans, left + right + root.val);
        return path;
    }
}
// @lc code=end

