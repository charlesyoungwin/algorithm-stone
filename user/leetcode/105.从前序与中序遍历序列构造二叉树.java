
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private Map<Integer, Integer> posMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        posMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            posMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 
            inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, 
            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = posMap.get(val);
        int distance = pos - inStart;
        root.left = build(preorder, preStart + 1, preStart + distance,
             inorder, inStart, pos - 1);
        root.right = build(preorder, preStart + distance + 1, preEnd, 
            inorder, pos + 1, inEnd);
        return root;
    }
}
// @lc code=end

