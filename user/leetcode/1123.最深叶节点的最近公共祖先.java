/*
 * @lc app=leetcode.cn id=1123 lang=java
 *
 * [1123] 最深叶节点的最近公共祖先
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

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        if (leftHeight == rightHeight) {
            return root;
        } else if (leftHeight < rightHeight) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    private int maxDepth = 0;

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        maxDepth = getDepth(root);
        if (root == null) {
            return null;
        }
        boolean leftContains = contains(root.left, 2);
        boolean rightContains = contains(root.right, 2);
        if (leftContains && rightContains) {
            return root;
        } else if (leftContains) {
            return lcaDeepestLeaves2(root.left);
        } else if (rightContains) {
            return lcaDeepestLeaves2(root.right);
        } else {
            return root;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean contains(TreeNode root, int depth) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (depth == maxDepth) {
                return true;
            } else {
                return false;
            }
        }
        return contains(root.left, depth + 1) || contains(root.right, depth + 1);
     }
}
// @lc code=end

