/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> res = new ArrayList<>();
        preorder(root, res);
        int size = res.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = res.get(i - 1);
            TreeNode curr = res.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
// @lc code=end

