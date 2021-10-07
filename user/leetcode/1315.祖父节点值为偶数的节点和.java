/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
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

    public int sumEvenGrandparent(TreeNode root) {
        dfs(1, 1, root);
        return res;
    }

    public void dfs(int grandParentVal, int parentVal, TreeNode root) {
        if (root == null) {
            return;
        }
        if (grandParentVal % 2 == 0) {
            res += root.val;
        }
        dfs(parentVal, root.val, root.left);
        dfs(parentVal, root.val, root.right);
        
    }
}
// @lc code=end

