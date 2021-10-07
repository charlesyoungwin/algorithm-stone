import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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

    private LinkedList<Integer> path;

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        path = new LinkedList<>();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += num;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }


}
// @lc code=end

