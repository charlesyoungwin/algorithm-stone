/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = arrowLength(root.left);
        int rightLength = arrowLength(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null && root.val == root.left.val) {
            arrowLeft = leftLength + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            arrowRight = rightLength + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end

