/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

    private TreeNode prevNode;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBst = isValidBST(root.left);
        if (prevNode != null) {
            if (root.val <= prevNode.val) {
                return false;
            }
        }
        prevNode = root;
        boolean rightBst = isValidBST(root.right);
        return leftBst && rightBst;
    }




    
}
// @lc code=end

