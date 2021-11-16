/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        containsNode(root, p, q);
        return res;
    }

    public void containsNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        containsNode(root.left, p, q);
        containsNode(root.right, p, q);
        if (res == null) {
            if (contains(root, p) && contains(root, q)) {
                res = root; 
            }
        }
    }

    public boolean contains(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root.val == target.val) {
            return true;
        }
        return contains(root.left, target) || contains(root.right, target);
    }
}
// @lc code=end

