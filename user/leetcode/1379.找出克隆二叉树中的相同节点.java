/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
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

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return traverse(original, cloned, target);
    }

    private TreeNode traverse(TreeNode node1, TreeNode node2, TreeNode target) {
        if (node1 == null) {
            return null;
        }
        if (node1 == target) {
            return node2;
        }
        TreeNode left = traverse(node1.left, node2.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = traverse(node1.right, node2.right, target);
        return right;
    }

}
// @lc code=end

