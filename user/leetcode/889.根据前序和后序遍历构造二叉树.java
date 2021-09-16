/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return toTree(preorder, 0, preorder.length - 1,
             postorder, 0, postorder.length - 1);
    }

    public TreeNode toTree(int[] preorder, int prestart, int preend, 
        int[] postorder, int poststart, int postend) {
        if (prestart > preend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend) {
            return root;
        }
        int i = poststart;
        while (i < postend && postorder[i] != preorder[prestart + 1]) {
            i++;
        }
        int len = i - poststart + 1;
        root.left = toTree(preorder, prestart + 1, prestart + len,
             postorder, poststart, i);
        root.right = toTree(preorder, prestart + len + 1, preend,
            postorder, i + 1, postend - 1);
        return root;
    }
}
// @lc code=end

