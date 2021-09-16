import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <=end; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
// @lc code=end

