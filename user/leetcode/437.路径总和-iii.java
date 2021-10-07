import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }


    public int dfs(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        targetSum = targetSum - val;
        if (targetSum == 0) {
            res++;
        }
        res += dfs(root.left, targetSum);
        res += dfs(root.right, targetSum);
        return res;
    }
}
// @lc code=end

