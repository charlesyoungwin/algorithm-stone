/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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

    private int res;

    private int min;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        res = -1;
        traverse(root);
        return res;
        
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (res != -1 && root.val >= res) {
            return;
        } 
        if (root.val > min) {
            res = root.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
// @lc code=end

