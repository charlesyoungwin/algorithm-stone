import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    private List<List<Integer>> result;

    private LinkedList<Integer> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        res = new LinkedList<>();
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        int val = root.val;
        res.add(val);
        targetSum = targetSum - val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(res));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        res.removeLast();
    }
}
// @lc code=end

