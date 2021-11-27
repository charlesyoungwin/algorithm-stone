/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, map, ans);
        return ans;
    }

    public String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if (root == null) {
            return "#";
        }
        String left = dfs(root.left, map, ans);
        String right = dfs(root.right, map, ans);
        String serial = root.val + "," + left + "," + right;
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            ans.add(root);
        }
        return serial;
    }
}
// @lc code=end

