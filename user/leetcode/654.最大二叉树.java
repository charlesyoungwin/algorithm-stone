/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = maxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructTree(nums, start, maxIndex - 1);
        root.right = constructTree(nums, maxIndex + 1, end);
        return root;
    }

    public int maxIndex(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

}
// @lc code=end

