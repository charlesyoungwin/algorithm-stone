/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 前序遍历构造二叉搜索树
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        int left = start + 1;
        while (left <= end && preorder[left] < val) {
            left++;
        }
        root.left = bstFromPreorder(preorder, start + 1, left - 1);
        root.right = bstFromPreorder(preorder, left, end);
        return root;
    }
}
// @lc code=end

