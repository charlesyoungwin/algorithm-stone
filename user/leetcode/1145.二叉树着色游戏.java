/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
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

    private int xLeft = 0;
    private int xRight = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int parent = n - xLeft - xRight - 1;
        return xLeft > n / 2 || xRight > n / 2 || parent > n / 2;
    }

    public int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, x);
        int right = dfs(root.right, x);
        if (root.val == x) {
            xLeft = left;
            xRight = right;
        }
        return left + right + 1;
    }


}
// @lc code=end

