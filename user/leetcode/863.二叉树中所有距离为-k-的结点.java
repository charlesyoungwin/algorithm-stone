/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
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

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        findNode(target, null, 0, k);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right);
        }
    }

    public void findNode(TreeNode root, TreeNode fromNode, int depth, int k) {
        if (root == null) {
            return;
        }
        if (depth == k) {
            result.add(root.val);
            return;
        }
        if (root.left != fromNode) {
            findNode(root.left, root, depth + 1, k);
        }
        if (root.right != fromNode) {
            findNode(root.right, root, depth + 1, k);
        }
        if (parentMap.get(root) != fromNode) {
            findNode(parentMap.get(root), root, depth + 1, k);
        }
    }
}
// @lc code=end

