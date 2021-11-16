/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
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

    private int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    public void dfs(TreeNode root, int smallest, int largest) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.max(Math.abs(smallest - root.val), 
                Math.abs(largest - root.val)));
        smallest = Math.min(root.val, smallest);
        largest = Math.max(root.val, largest);
        dfs(root.left, smallest, largest);
        dfs(root.right, smallest, largest);
    }

    public int maxAncestorDiff2(TreeNode root) {
        traverse(root);
        return res;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            res = Math.max(res, 0);
            return new int[]{root.val, root.val};
        }
        int[] leftRes = traverse(root.left);
        int[] rightRes = traverse(root.right);
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        if (leftRes != null) {
            low = Math.min(low, leftRes[0]);
            high = Math.max(high, leftRes[1]);
        }
        if (rightRes != null) {
            low = Math.min(low, rightRes[0]);
            high = Math.max(high, rightRes[1]);
        }
        int val = Math.max(Math.abs(root.val - low), Math.abs(root.val - high));
        res = Math.max(res, val);
        return new int[]{Math.min(low, root.val),
            Math.max(high, root.val)};

    }
}
// @lc code=end

