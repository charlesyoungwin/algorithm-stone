/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    Map<Integer, Integer> posMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        posMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            posMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, 
            postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int instart, int inend, 
        int[] postorder, int poststart, int postend) {
        if (instart > inend || poststart > postend) {
            return null;
        }
        int val = postorder[postend];
        TreeNode root = new TreeNode(val);
        int pos = posMap.get(val);    
        int distance = pos - instart;
        root.left = build(inorder, instart, pos - 1, 
            postorder, poststart, poststart + distance - 1);
        root.right = build(inorder, pos + 1, inend, 
            postorder, poststart + distance, postend - 1);
        return root;
    }
}
// @lc code=end

