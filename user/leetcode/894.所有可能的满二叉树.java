/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的满二叉树
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

    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }    
        List<TreeNode> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                int j = n - 1 - i;
                for (TreeNode left : allPossibleFBT(i)) {
                    for (TreeNode right : allPossibleFBT(j)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        memo.put(n, ans);
        return ans;
    }
}
// @lc code=end

